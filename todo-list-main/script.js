// DOM Elements
const themeBtn = document.getElementById('theme-btn');
const addTaskBtn = document.getElementById('add-task-btn');
const searchInput = document.getElementById('search-input');
const priorityFilter = document.getElementById('priority-filter');
const tasksContainer = document.querySelector('.tasks-container');
const currentListDisplay = document.getElementById('current-list');
const taskModal = document.getElementById('task-modal');
const taskForm = document.getElementById('task-form');
const taskIdInput = document.getElementById('task-id');
const taskTitleInput = document.getElementById('task-title');
const taskDescriptionInput = document.getElementById('task-description');
const taskPrioritySelect = document.getElementById('task-priority');

// Navigation buttons
const allTasksBtn = document.querySelector('[data-list="all"]');
const importantBtn = document.querySelector('[data-list="important"]');

// State
let tasks = JSON.parse(localStorage.getItem('tasks')) || [];
let currentList = 'all';
let isEditingTask = false;
let currentTaskId = null;

// Initialize the app
function init() {
    loadTheme();
    renderTasks();
    setupEventListeners();
}

// Event Listeners
function setupEventListeners() {
    // Theme toggle
    themeBtn.addEventListener('click', toggleTheme);
    
    // Task buttons
    addTaskBtn.addEventListener('click', openTaskModal);
    
    // Navigation buttons
    allTasksBtn.addEventListener('click', () => {
        currentList = 'all';
        allTasksBtn.classList.add('active');
        importantBtn.classList.remove('active');
        currentListDisplay.textContent = 'All Tasks';
        renderTasks();
    });
    
    importantBtn.addEventListener('click', () => {
        currentList = 'important';
        importantBtn.classList.add('active');
        allTasksBtn.classList.remove('active');
        currentListDisplay.textContent = 'Things to stress about';
        renderTasks();
    });
    
    // Task form
    taskForm.addEventListener('submit', handleTaskSubmit);
    
    // Modal close/cancel
    document.querySelector('.close-modal').addEventListener('click', closeTaskModal);
    document.getElementById('cancel-task').addEventListener('click', closeTaskModal);
    
    // Search and filter
    searchInput.addEventListener('input', renderTasks);
    priorityFilter.addEventListener('change', renderTasks);
}

// Theme functions
function toggleTheme() {
    document.body.setAttribute('data-theme', 
        document.body.getAttribute('data-theme') === 'dark' ? 'light' : 'dark');
    themeBtn.innerHTML = document.body.getAttribute('data-theme') === 'dark' ? 
        '<i class="fas fa-sun"></i>' : '<i class="fas fa-moon"></i>';
    localStorage.setItem('theme', document.body.getAttribute('data-theme'));
}

function loadTheme() {
    const savedTheme = localStorage.getItem('theme') || 'light';
    document.body.setAttribute('data-theme', savedTheme);
    themeBtn.innerHTML = savedTheme === 'dark' ? 
        '<i class="fas fa-sun"></i>' : '<i class="fas fa-moon"></i>';
}

// Task functions
function openTaskModal() {
    taskModal.style.display = 'flex';
    taskTitleInput.focus();
}

function closeTaskModal() {
    taskModal.style.display = 'none';
    resetTaskForm();
}

function handleTaskSubmit(e) {
    e.preventDefault();
    
    const taskData = {
        id: isEditingTask ? taskIdInput.value : Date.now().toString(),
        title: taskTitleInput.value.trim(),
        description: taskDescriptionInput.value.trim(),
        priority: taskPrioritySelect.value,
        completed: false
    };
    
    if (!taskData.title) {
        alert('Task title is required!');
        return;
    }
    
    if (isEditingTask) {
        const index = tasks.findIndex(t => t.id === taskData.id);
        if (index !== -1) {
            tasks[index] = taskData;
        }
    } else {
        tasks.push(taskData);
    }
    
    saveTasks();
    renderTasks();
    closeTaskModal();
}

function renderTasks() {
    const searchTerm = searchInput.value.toLowerCase();
    const priorityFilterValue = priorityFilter.value;
    
    let filteredTasks = tasks.filter(task => {
        // Filter by current view
        if (currentList === 'important') {
            return task.priority === 'high';
        }
        
        // Filter by search term
        if (searchTerm && !task.title.toLowerCase().includes(searchTerm)) {
            return false;
        }
        
        // Filter by priority
        if (priorityFilterValue !== 'all' && task.priority !== priorityFilterValue) {
            return false;
        }
        
        return true;
    });
    
    // Sort tasks: incomplete first, then by priority
    filteredTasks.sort((a, b) => {
        if (a.completed !== b.completed) return a.completed ? 1 : -1;
        const priorityOrder = { high: 1, medium: 2, low: 3 };
        return priorityOrder[a.priority] - priorityOrder[b.priority];
    });
    
    tasksContainer.innerHTML = '';
    
    if (filteredTasks.length === 0) {
        tasksContainer.innerHTML = `
            <div class="empty-state">
                <i class="fas fa-check-circle"></i>
                <p>No tasks to display. Add a new task to get started!</p>
            </div>
        `;
        return;
    }
    
    filteredTasks.forEach(task => {
        const taskElement = createTaskElement(task);
        tasksContainer.appendChild(taskElement);
    });
}

function createTaskElement(task) {
    const taskElement = document.createElement('div');
    taskElement.className = `task-card ${task.completed ? 'completed' : ''}`;
    
    taskElement.innerHTML = `
        <div class="task-card-header">
            <div class="task-title">
                <input type="checkbox" class="task-checkbox" ${task.completed ? 'checked' : ''} data-task-id="${task.id}">
                ${task.title}
            </div>
            <div class="task-actions">
                <button class="task-action-btn edit-task" data-task-id="${task.id}">
                    <i class="fas fa-edit"></i>
                </button>
                <button class="task-action-btn delete-task" data-task-id="${task.id}">
                    <i class="fas fa-trash"></i>
                </button>
            </div>
        </div>
        <div class="task-details">
            <span class="task-priority ${task.priority}">${task.priority}</span>
        </div>
        ${task.description ? `<div class="task-description">${task.description}</div>` : ''}
    `;
    
    // Add event listeners
    const checkbox = taskElement.querySelector('.task-checkbox');
    checkbox.addEventListener('change', () => toggleTaskCompletion(task.id));
    
    const editBtn = taskElement.querySelector('.edit-task');
    editBtn.addEventListener('click', () => editTask(task.id));
    
    const deleteBtn = taskElement.querySelector('.delete-task');
    deleteBtn.addEventListener('click', () => deleteTask(task.id));
    
    return taskElement;
}

function toggleTaskCompletion(taskId) {
    const task = tasks.find(t => t.id === taskId);
    if (task) {
        task.completed = !task.completed;
        saveTasks();
        renderTasks();
    }
}

function editTask(taskId) {
    const task = tasks.find(t => t.id === taskId);
    if (task) {
        taskIdInput.value = task.id;
        taskTitleInput.value = task.title;
        taskDescriptionInput.value = task.description || '';
        taskPrioritySelect.value = task.priority || 'medium';
        isEditingTask = true;
        document.getElementById('modal-title').textContent = 'Edit Task';
        openTaskModal();
    }
}

function deleteTask(taskId) {
    if (confirm('Are you sure you want to delete this task?')) {
        tasks = tasks.filter(t => t.id !== taskId);
        saveTasks();
        renderTasks();
    }
}

function saveTasks() {
    localStorage.setItem('tasks', JSON.stringify(tasks));
}

function resetTaskForm() {
    taskForm.reset();
    taskIdInput.value = '';
    isEditingTask = false;
    document.getElementById('modal-title').textContent = 'Add New Task';
}

// Initialize the app
init();