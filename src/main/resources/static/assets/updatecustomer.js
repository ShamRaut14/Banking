//function handleCustomerSubmit(event) {
//    event.preventDefault(); // Prevent default form submission
//
//    const form = document.getElementById('customerForm');
//    const partyid = document.getElementById('partyid').value;
//
//    const url = partyid ? 'updateCustomer' : 'saveCustomer'; // Determine the endpoint
//    const method = partyid ? 'PUT' : 'POST'; // Determine the HTTP method
//
//    fetch(url, {
//        method: method,
//        body: new FormData(form)
//    })
//    .then(response => response.json())
//    .then(data => {
//        if (data.success) {
//            Swal.fire('Success', data.message, 'success');
//        } else {
//            Swal.fire('Error', data.message, 'error');
//        }
//    })
//    .catch(error => {
//        Swal.fire('Error', 'An error occurred while saving or updating customer data', 'error');
//    });
//}

function handleCustomerSubmit(event) {
    event.preventDefault(); // Prevent default form submission

    const form = document.getElementById('customerForm');
    const partyid = document.getElementById('partyid').value;

    const url = partyid ? '/update-customer' : '/save-customer'; // Corrected endpoints
    const method = partyid ? 'PUT' : 'POST'; // Determine the HTTP method

    fetch(url, {
        method: method,
        body: new FormData(form)
    })
    .then(response => {
        // Check if the response is OK (status in the range 200-299)
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        console.log('Server response:', data); // Log the server response for debugging
        if (data.success) {
            Swal.fire('Success', data.message, 'success');
        } else {
            Swal.fire('Error', data.message || 'An unexpected error occurred', 'error');
        }
    })
    .catch(error => {
        console.error('Error during fetch:', error); // Log the error for debugging
        Swal.fire('Error', 'An error occurred while saving or updating customer data: ' + error.message, 'error');
    });
}
