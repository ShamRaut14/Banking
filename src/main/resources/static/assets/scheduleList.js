
document.getElementById('scheduleButton').addEventListener('click', function() {
    fetchData('/allSchedule'); // Call the function with the endpoint for schedules
});

function fetchData(endpoint) {
    // Fetch data from the server using AJAX
    fetch(endpoint)
        .then(response => response.json())
        .then(data => {
            let tableTitle = '';
            let tableHeaders = '';
            let tableRows = '';


            if(endpoint === '/allSchedule') {
                tableTitle = 'Schedule List';
                tableHeaders = `
                    <tr>
                        <th style="border: 1px solid #ddd; padding: 8px;">Schedule ID</th>
                        <th style="border: 1px solid #ddd; padding: 8px;">name</th>

                    </tr>
                `;
                data.forEach(schedule => {
                    tableRows += `
                        <tr>
                            <td style="border: 1px solid #ddd; padding: 8px;">${schedule.scheduleId}</td>
                            <td style="border: 1px solid #ddd; padding: 8px;">${schedule.name}</td>

                        </tr>
                    `;
                });
            }

            // Prepare the table in HTML format
            let tableHTML = `
                <table style="width: 100%; border-collapse: collapse; border: 1px solid #ddd;">
                    <thead>${tableHeaders}</thead>
                    <tbody>${tableRows}</tbody>
                </table>
            `;

            // Display the SweetAlert2 popup with the table
            Swal.fire({
                title: tableTitle,
                html: tableHTML,
                icon: 'info',
                confirmButtonText: 'Close'
            });
        })
        .catch(error => {
            console.error('Error fetching data:', error);
            Swal.fire({
                title: 'Error',
                text: 'Unable to fetch data. Please try again later.',
                icon: 'error',
                confirmButtonText: 'Close'
            });
        });
}