const weatherData = {
    "delhi": {
        city: "Delhi, India",
        temp: 22,
        description: "Partly Cloudy",
        icon: "wi-day-cloudy",
        wind: 12,
        humidity: 65,
        pressure: 1012,
        forecast: [
            { day: "Tue", icon: "wi-day-sunny", temp: 24 },
            { day: "Wed", icon: "wi-day-cloudy", temp: 21 },
            { day: "Thu", icon: "wi-rain", temp: 18 },
            { day: "Fri", icon: "wi-day-sunny", temp: 25 },
            { day: "Sat", icon: "wi-night-clear", temp: 20 }
        ]
    },
    "london": {
        city: "London, UK",
        temp: 15,
        description: "Light Rain",
        icon: "wi-rain",
        wind: 18,
        humidity: 82,
        pressure: 1005,
        forecast: [
            { day: "Tue", icon: "wi-rain", temp: 14 },
            { day: "Wed", icon: "wi-cloudy", temp: 16 },
            { day: "Thu", icon: "wi-day-sunny", temp: 19 },
            { day: "Fri", icon: "wi-day-cloudy", temp: 17 },
            { day: "Sat", icon: "wi-showers", temp: 13 }
        ]
    },
    "tokyo": {
        city: "Tokyo, Japan",
        temp: 28,
        description: "Sunny",
        icon: "wi-day-sunny",
        wind: 8,
        humidity: 55,
        pressure: 1015,
        forecast: [
            { day: "Tue", icon: "wi-day-sunny", temp: 30 },
            { day: "Wed", icon: "wi-day-sunny", temp: 31 },
            { day: "Thu", icon: "wi-day-cloudy", temp: 27 },
            { day: "Fri", icon: "wi-rain", temp: 25 },
            { day: "Sat", icon: "wi-thunderstorm", temp: 23 }
        ]
    },
    "sydney": {
        city: "Sydney, Australia",
        temp: 19,
        description: "Cloudy",
        icon: "wi-cloudy",
        wind: 14,
        humidity: 72,
        pressure: 1018,
        forecast: [
            { day: "Tue", icon: "wi-cloudy", temp: 18 },
            { day: "Wed", icon: "wi-showers", temp: 17 },
            { day: "Thu", icon: "wi-day-sunny", temp: 22 },
            { day: "Fri", icon: "wi-day-sunny", temp: 24 },
            { day: "Sat", icon: "wi-day-cloudy", temp: 20 }
        ]
    }
};

const cityInput = document.getElementById('cityInput');
const searchBtn = document.getElementById('searchBtn');
const cityName = document.getElementById('cityName');
const currentDate = document.getElementById('currentDate');
const temperature = document.getElementById('temperature');
const weatherIcon = document.getElementById('weatherIcon');
const weatherDescription = document.getElementById('weatherDescription');
const windSpeed = document.getElementById('windSpeed');
const humidity = document.getElementById('humidity');
const pressure = document.getElementById('pressure');
const forecastContainer = document.getElementById('forecastContainer');

const today = new Date();
currentDate.textContent = today.toLocaleDateString('en-US', { 
    weekday: 'long', 
    month: 'long', 
    day: 'numeric' 
});

function searchWeather() {
    const searchTerm = cityInput.value.toLowerCase().trim();
    
    if (weatherData[searchTerm]) {
        const data = weatherData[searchTerm];
        
        cityName.textContent = data.city;
        temperature.textContent = data.temp;
        weatherIcon.className = `wi ${data.icon}`;
        weatherDescription.textContent = data.description;
        windSpeed.textContent = `${data.wind} mph`;
        humidity.textContent = `${data.humidity}%`;
        pressure.textContent = `${data.pressure} mb`;
        
        forecastContainer.innerHTML = '';
        data.forecast.forEach(day => {
            forecastContainer.innerHTML += `
                <div class="forecast-day">
                    <p>${day.day}</p>
                    <i class="wi ${day.icon}"></i>
                    <p>${day.temp}°C</p>
                </div>
            `;
        });
    } else {
        alert("City not found in our database. Try New York, London, Tokyo, or Sydney.");
    }
}

searchBtn.addEventListener('click', searchWeather);
cityInput.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') {
        searchWeather();
    }
});