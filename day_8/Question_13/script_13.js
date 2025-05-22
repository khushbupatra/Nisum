async function fetchData() {
  const url = 'https://api.publicapis.org/entries';

  try {
    const response = await fetch(url);

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const data = await response.json();
    console.log('Fetched data:', data);
    return data;

  } catch (error) {
    if (error instanceof TypeError) {
      console.error('Network error:', error.message);
    } else if (error instanceof SyntaxError) {
      console.error('JSON parsing error:', error.message);
    } else {
      console.error('Error fetching data:', error.message);
    }

    return null;
  }
}

fetchData()
  .then(data => {
    if (data) {
      console.log('Number of entries:', data.count);
    }
  });