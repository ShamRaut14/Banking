$(document).ready(function() {
    $('#deleteButton').click(function() {
        const partyid = $('#party-id').val(); // Get the currently selected partyid

        if (partyid) {
            // SweetAlert2 confirmation dialog
            Swal.fire({
                title: 'Are you sure?',
                text: 'Do you really want to delete this record?',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    // If confirmed, perform the delete action
                    $.ajax({
                        url: '/deletedata/' + partyid,  // Ensure your controller handles this URL
                        type: 'DELETE',
                        success: function(response) {
                            Swal.fire(
                                'Deleted!',
                                'The record has been deleted.',
                                'success'
                            ).then(function () {
                                // Refresh the page when "OK" is clicked
                               window.location.reload();
                              });
                        },
                        error: function(xhr, status, error) {
                            console.log("Error deleting customer data: " + error);
                            Swal.fire(
                                'Error!',
                                'Failed to delete the record.',
                                'error'
                            );
                        }
                    });
                }
            });
        } else {
            Swal.fire(
                'Warning!',
                'No party ID selected for deletion.',
                'warning'
            );
        }
    });
});

