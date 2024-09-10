  document.getElementById('listButton').addEventListener('click', function() {
        // Fetch the customer data from the server using AJAX
        fetch('/allcustomer') // Replace with your actual API endpoint
            .then(response => response.json())
            .then(data => {
                // Prepare the table of customers in HTML format
                let customerTable = `
                    <table style="width: 100%; border-collapse: collapse; border: 1px solid #ddd;">
                        <thead>
                            <tr>
                                <th style="border: 1px solid #ddd; padding: 8px;">First Name</th>
                                <th style="border: 1px solid #ddd; padding: 8px;">Middle Name</th>
                                <th style="border: 1px solid #ddd; padding: 8px;">Surname</th>
                                <th style="border: 1px solid #ddd; padding: 8px;">Party ID</th>
                            </tr>
                        </thead>
                        <tbody>
                `;

                // Iterate over the data and create table rows
                data.forEach(customer => {
                    customerTable += `
                        <tr>
                            <td style="border: 1px solid #ddd; padding: 8px;">${customer.firstname}</td>
                            <td style="border: 1px solid #ddd; padding: 8px;">${customer.middlename}</td>
                            <td style="border: 1px solid #ddd; padding: 8px;">${customer.surname}</td>
                            <td style="border: 1px solid #ddd; padding: 8px;">${customer.partyid}</td>
                        </tr>
                    `;
                });

                customerTable += `
                        </tbody>
                    </table>
                `;

                // Display the SweetAlert2 popup with the customer table
                Swal.fire({
                    title: 'Customer List',
                    html: customerTable,
                    icon: 'info',
                    confirmButtonText: 'Close'
                });
            })
            .catch(error => {
                console.error('Error fetching customer data:', error);
                Swal.fire({
                    title: 'Error',
                    text: 'Unable to fetch customer data. Please try again later.',
                    icon: 'error',
                    confirmButtonText: 'Close'
                });
            });
    });

