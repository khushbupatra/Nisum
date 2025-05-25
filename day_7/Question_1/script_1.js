document.querySelectorAll('nav a').forEach(link => {
    const path = link.getAttribute('href');

    link.addEventListener('click', (event) => {
        event.preventDefault();
        const targetSection = link.getAttribute('data-section');
        document.querySelectorAll('section').forEach(section => {
            section.classList.remove('active');
        });
        document.getElementById(targetSection).classList.add('active');
        history.pushState(null, null, path);
    });

    link.addEventListener('mouseover', (event) => {
        event.target.style.color = 'white';
    });

    link.addEventListener('mouseout', (event) => {
        event.target.style.color = '';
    });
});
window.addEventListener('popstate', () => {
    const currentPath = window.location.pathname || '/home';
    const sectionId = currentPath.substring(1); // Remove leading slash

    document.querySelectorAll('section').forEach(section => {
        section.classList.remove('active');
    });

    if (document.getElementById(sectionId)) {
        document.getElementById(sectionId).classList.add('active');
    } else {
        document.getElementById('home').classList.add('active');
    }
});