//$(document).ready(function () {
//    $('#customerForm').on('submit', function (event) {
//        event.preventDefault(); // Prevent default form submission
//
//        // Collect form data
//        var formData = new FormData(this);
//
//        // Check if the element exists before accessing its value
//        var partyidElement = document.getElementById('party-id');
//        if (partyidElement === null) {
//            console.error('The element with id "partyid" was not found.');
//            return;
//        }
//
//        var partyid = partyidElement.value;
//
//        // Check if the partyid exists in the database
//        $.ajax({
//            url: '/check-partyid', // Endpoint to check if partyid exists
//            type: 'GET',
//            data: { partyid: partyid },
//            success: function (checkResponse) {
//                var url;
//                if (checkResponse.exists) {
//                    // If partyid exists, set URL for updating the customer
//                    url = '/update-customer';
//                } else {
//                    // If partyid does not exist, set URL for creating a new customer
//                    url = '/new-customer';
//                }
//
//                // Perform AJAX POST request to create or update customer
//                $.ajax({
//                    url: url,
//                    type: 'POST',
//                    data: formData,
//                    processData: false, // Prevent jQuery from automatically processing the data
//                    contentType: false, // Prevent jQuery from setting content type
//                    dataType: 'json', // Expecting JSON response
//                    success: function (response) {
//                        console.log('AJAX Success Response:', response); // Debugging line for response
//
//                        if (response.status === 'success') {
//                            Swal.fire({
//                                icon: 'success',
//                                title: 'Success!',
//                                text: response.message,
//                                confirmButtonText: 'OK'
//                            }).then(function () {
//                                 // Refresh the page when "OK" is clicked
//                                window.location.reload();
//                               });
//                        } else if (response.status === 'party_ID_exist') {
//                            Swal.fire({
//                                icon: 'error',
//                                title: 'Error!',
//                                text: response.message,
//                                confirmButtonText: 'OK'
//                            })
//                               .then(function () {
//                                 // Refresh the page when "OK" is clicked
//                                window.location.reload();
//                               });
//                        } else if (response.status === 'partyid_null') {
//                            Swal.fire({
//                                icon: 'error',
//                                title: 'Error!',
//                                text: response.message,
//                                confirmButtonText: 'OK'
//                            }).then(function () {
//                               // Refresh the page when "OK" is clicked
//                                window.location.reload();
//                                });
//                        }
//                    },
//                    error: function (xhr) {
//                        Swal.fire({
//                            icon: 'error',
//                            title: 'Error!',
//                            text: 'An unexpected error occurred.',
//                            confirmButtonText: 'OK'
//                        }).then(function () {
//                          // Refresh the page when "OK" is clicked
//                         window.location.reload();
//                        });
//                    }
//                });
//            },
//            error: function (xhr) {
//                Swal.fire({
//                    icon: 'error',
//                    title: 'Error!',
//                    text: 'Failed to check party ID existence.',
//                    confirmButtonText: 'OK'
//                }).then(function () {
//                   // Refresh the page when "OK" is clicked
//                  window.location.reload();
//                 });
//            }
//        });
//    });
//});
//
//

$(document).ready(function () {
    $('#customerForm').on('submit', function (event) {
        event.preventDefault(); // Prevent default form submission

        // Collect form data
        var formData = new FormData(this);

        // Check if the element exists before accessing its value
        var partyidElement = document.getElementById('party-id');
        if (partyidElement === null) {
            console.error('The element with id "partyid" was not found.');
            return;
        }

        var partyid = partyidElement.value;

        // Check if the partyid exists in the database
        $.ajax({
            url: '/check-partyid', // Endpoint to check if partyid exists
            type: 'GET',
            data: { partyid: partyid },
            success: function (checkResponse) {
                var url;
                var method;
                if (checkResponse.exists) {
                    // If partyid exists, set URL for updating the customer
                    url = '/update-customer';
                    method = 'PUT'; // Set HTTP method to PUT for update
                } else {
                    // If partyid does not exist, set URL for creating a new customer
                    url = '/new-customer';
                    method = 'POST'; // Set HTTP method to POST for creation
                }

                // Perform AJAX request to create or update customer
                $.ajax({
                    url: url,
                    type: method, // Dynamically set the HTTP method
                    data: formData,
                    processData: false, // Prevent jQuery from automatically processing the data
                    contentType: false, // Prevent jQuery from setting content type
                    dataType: 'json', // Expecting JSON response
                    success: function (response) {
                        console.log('AJAX Success Response:', response); // Debugging line for response

                        if (response.status === 'success') {
                            Swal.fire({
                                icon: 'success',
                                title: 'Success!',
                                text: response.message,
                                confirmButtonText: 'OK'
                            }).then(function () {
                                window.location.reload(); // Refresh the page
                            });
                        } else if (response.status === 'party_ID_exist') {
                            Swal.fire({
                                icon: 'error',
                                title: 'Error!',
                                text: response.message,
                                confirmButtonText: 'OK'
                            }).then(function () {
                                window.location.reload(); // Refresh the page
                            });
                        } else if (response.status === 'partyid_null') {
                            Swal.fire({
                                icon: 'error',
                                title: 'Error!',
                                text: response.message,
                                confirmButtonText: 'OK'
                            }).then(function () {
                                window.location.reload(); // Refresh the page
                            });
                        }
                    },
                    error: function (xhr) {
                        Swal.fire({
                            icon: 'error',
                            title: 'Error!',
                            text: 'An unexpected error occurred.',
                            confirmButtonText: 'OK'
                        }).then(function () {
                            window.location.reload(); // Refresh the page
                        });
                    }
                });
            },
            error: function (xhr) {
                Swal.fire({
                    icon: 'error',
                    title: 'Error!',
                    text: 'Failed to check party ID existence.',
                    confirmButtonText: 'OK'
                }).then(function () {
                    window.location.reload(); // Refresh the page
                });
            }
        });
    });
});
