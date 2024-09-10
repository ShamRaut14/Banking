//function showSuggestions() {
//    const searchText = $('#party-id').val();
//
//    if ($.isNumeric(searchText)) {
//        // Fetch by partyid if input is numeric
//        $.ajax({
//            url: '/party_id',
//            type: 'GET',
//            data: { query: searchText },
//            success: function(data) {
//                let suggestionsDiv = $('#suggestions');
//                suggestionsDiv.empty().show();
//
//                if (data && data.partyid) {
//                    let suggestionItem = $('<div class="suggestion-item">' + data.partyid + '</div>');
//                    suggestionItem.data('partyid', data.partyid);
//                    suggestionsDiv.append(suggestionItem);
//                }
//
//                attachSuggestionClickEvent();
//            },
//            error: function(xhr, status, error) {
//                console.log("Error fetching party IDs: " + error);
//            }
//        });
//    } else {
//        // Fetch by name if input is alphabetic
//        $.ajax({
//            url: '/getname',
//            type: 'GET',
//            data: { query: searchText },
//            success: function(data) {
//                let suggestionsDiv = $('#suggestions');
//                suggestionsDiv.empty().show();
//
//                if (data && data.length > 0) {
//                    data.forEach(function(item) {
//                        let suggestionItem = $('<div class="suggestion-item">' + item.firstname + ' ' + item.surname + ' (ID: ' + item.partyid + ')</div>');
//                        suggestionItem.data('partyid', item.partyid);
//                        suggestionsDiv.append(suggestionItem);
//                    });
//                }
//
//                attachSuggestionClickEvent();
//            },
//            error: function(xhr, status, error) {
//                console.log("Error fetching customer names: " + error);
//            }
//        });
//    }
//}
//
//function attachSuggestionClickEvent() {
//    // Attach click event to suggestion items
//    $('.suggestion-item').click(function() {
//        let selectedPartyId = $(this).data('partyid');
//        $('#party-id').val(selectedPartyId);
//        hideSuggestions();
//        fetchCustomerData(selectedPartyId);
//    });
//}
//
//function fetchCustomerData(partyid) {
//    $.ajax({
//        url: '/getCustomerData/' + partyid,
//        type: 'GET',
//        success: function(data) {
//            console.log('Fetched data:', data);
//             $('#party-id').val(data.partyid);
//                    $('#title-en').val(data.nametitle);
//                    $('#firstname').val(data.firstname);
//                    $('#middlename').val(data.middlename);
//                    $('#surname').val(data.surname);
//                    $('#dob').val(data.dob);
//                    $('#age').val(data.age);
//                    $('#gender').val(data.gender);
//                    $('#religion').val(data.religion);
//                    $('#category').val(data.category);
//                    $('#subcast').val(data.subcast);
//                    $('#education').val(data.education);
//                    $('#occupation').val(data.occupation);
//                    $('#pan').val(data.pan);
//                    $('#adhar').val(data.adhar);
//                    $('#sms').val(data.sms);
//                    $('#is-joint-party').val(data.isjoint);
//                    $('#openingDate').val(data.openingDate);
//                    $('#manualCode').val(data.manualCode);
//                    $('#Address').val(data.address);
//                    $('#addressProof').val(data.addressProof);
//                    $('#identity').val(data.identity);
//                    $('#officeAddress').val(data.officeAddress);
//                    $('#phoneNo').val(data.phoneNo);
//                    $('#mobileNo').val(data.mobileNo);
//                    $('#village').val(data.village);
//                    $('#city').val(data.city);
//                    $('#state').val(data.state);
//                    $('#country').val(data.country);
//                    $('#email').val(data.email);
//                    $('#pin').val(data.pin);
//                    $('#bankName').val(data.bankName);
//                    $('#accountNo').val(data.accountNo);
//                    $('#ifsc').val(data.ifsc);
//                    $('#seniorCitizen').prop('checked', data.seniorCitizen);
//                    $('#active').prop('checked', data.active);
//
//                    // Populate photo and sign paths if present
//                    if (data.photoPath) {
//                        $('#imagePreview1').attr('src', data.photoPath).show();
//                    }
//                    if (data.signPath) {
//                        $('#imagePreview2').attr('src', data.signPath).show();
//                    }
//                    if (data.addProofpath) {
//                        $('#imagePreviewAddProof').attr('src', data.addProofpath).show();
//                    }
//                    if (data.idproofpath) {
//                        $('#imagePreviewIDProof').attr('src', data.idproofpath).show();
//                    }
//        },
//        error: function(xhr, status, error) {
//            console.log("Error fetching customer data: " + error);
//        }
//    });
//}
//
//function hideSuggestions() {
//    $('#suggestions').hide();
//}
//
//$(document).click(function(e) {
//    if (!$(e.target).closest('#party-id, #suggestions').length) {
//        hideSuggestions();
//    }
//});
//
//$('#party-id').on('input', function() {
//    showSuggestions();
//});


function showSuggestions() {
    const searchText = $('#party-id').val();

    if ($.isNumeric(searchText)) {
        // Fetch by partyid if input is numeric
        $.ajax({
            url: '/party_id',
            type: 'GET',
            data: { query: searchText },
            success: function(data) {
                let suggestionsDiv = $('#suggestions');
                suggestionsDiv.empty().show();

                if (data && data.partyid) {
                    let suggestionItem = $('<div class="suggestion-item">' + data.partyid + '</div>');
                    suggestionItem.data('partyid', data.partyid);
                    suggestionsDiv.append(suggestionItem);
                }

                attachSuggestionClickEvent();
            },
            error: function(xhr, status, error) {
                console.log("Error fetching party IDs: " + error);
            }
        });
    } else {
        // Fetch by name if input is alphabetic
        $.ajax({
            url: '/getname',
            type: 'GET',
            data: { query: searchText },
            success: function(data) {
                let suggestionsDiv = $('#suggestions');
                suggestionsDiv.empty().show();

                if (data && data.length > 0) {
                    data.forEach(function(item) {
                        let suggestionItem = $('<div class="suggestion-item">' + item.firstname + ' ' + item.surname + ' (ID: ' + item.partyid + ')</div>');
                        suggestionItem.data('partyid', item.partyid);
                        suggestionsDiv.append(suggestionItem);
                    });
                }

                attachSuggestionClickEvent();
            },
            error: function(xhr, status, error) {
                console.log("Error fetching customer names: " + error);
            }
        });
    }
}

function attachSuggestionClickEvent() {
    // Attach click event to suggestion items
    $('.suggestion-item').click(function() {
        let selectedPartyId = $(this).data('partyid');
        $('#party-id').val(selectedPartyId);
        hideSuggestions();
        fetchCustomerData(selectedPartyId);
    });
}

function fetchCustomerData(partyid) {
    $.ajax({
        url: '/getCustomerData/' + partyid,
        type: 'GET',
        success: function(data) {
            console.log('Fetched data:', data);

             $('#imagePreview1').attr('src', '').hide();
                        $('#imagePreview2').attr('src', '').hide();
                        $('#imagePreviewAddProof').attr('src', '').hide();
                        $('#imagePreviewIDProof').attr('src', '').hide();

            $('#party-id').val(data.partyid);
            $('#title-en').val(data.nametitle);
            $('#firstname').val(data.firstname);
            $('#middlename').val(data.middlename);
            $('#surname').val(data.surname);
            $('#dob').val(data.dob);
            $('#age').val(data.age);
            $('#gender').val(data.gender);
            $('#religion').val(data.religion);
            $('#category').val(data.category);
            $('#subcast').val(data.subcast);
            $('#education').val(data.education);
            $('#occupation').val(data.occupation);
            $('#pan').val(data.pan);
            $('#adhar').val(data.adhar);
            $('#sms').val(data.sms);
            $('#is-joint-party').val(data.isjoint);
            $('#openingDate').val(data.openingDate);
            $('#manualCode').val(data.manualCode);
            $('#Address').val(data.address);
            $('#addressProof').val(data.addressProof);
            $('#identity').val(data.identity);
            $('#officeAddress').val(data.officeAddress);
            $('#phoneNo').val(data.phoneNo);
            $('#mobileNo').val(data.mobileNo);
            $('#village').val(data.village);
            $('#city').val(data.city);
            $('#state').val(data.state);
            $('#country').val(data.country);
            $('#email').val(data.email);
            $('#pin').val(data.pin);
            $('#bankName').val(data.bankName);
            $('#accountNo').val(data.accountNo);
            $('#ifsc').val(data.ifsc);
            $('#seniorCitizen').prop('checked', data.seniorCitizen);
            $('#active').prop('checked', data.active);

            // Populate photo and sign paths if present
            if (data.photoPath) {
                $('#imagePreview1').attr('src', data.photoPath).show();
            }
            if (data.signPath) {
                $('#imagePreview2').attr('src', data.signPath).show();
            }
            if (data.addProofpath) {
                $('#imagePreviewAddProof').attr('src', data.addProofpath).show();
            }
            if (data.idproofpath) {
                $('#imagePreviewIDProof').attr('src', data.idproofpath).show();
            }
        },
        error: function(xhr, status, error) {
            console.log("Error fetching customer data: " + error);
        }
    });
}

function hideSuggestions() {
    $('#suggestions').hide();
}

$(document).click(function(e) {
    if (!$(e.target).closest('#party-id, #suggestions').length) {
        hideSuggestions();
    }
});

$('#party-id').on('input', function() {
    showSuggestions();
});

// Handle keyboard navigation
$('#party-id').on('keydown', function(e) {
    const suggestionsDiv = $('#suggestions');
    let selected = suggestionsDiv.find('.selected');

    if (e.key === 'ArrowDown') {
        if (!selected.length) {
            // Select the first suggestion if none are selected
            suggestionsDiv.find('.suggestion-item:first').addClass('selected');
        } else {
            // Move to the next suggestion
            let next = selected.next('.suggestion-item');
            if (next.length) {
                selected.removeClass('selected');
                next.addClass('selected');
            }
        }
        e.preventDefault();
    } else if (e.key === 'ArrowUp') {
        if (selected.length) {
            // Move to the previous suggestion
            let prev = selected.prev('.suggestion-item');
            if (prev.length) {
                selected.removeClass('selected');
                prev.addClass('selected');
            }
        }
        e.preventDefault();
    } else if (e.key === 'Enter') {
        if (selected.length) {
            // Select the current suggestion
            let selectedPartyId = selected.data('partyid');
            $('#party-id').val(selectedPartyId);
            hideSuggestions();
            fetchCustomerData(selectedPartyId);
            e.preventDefault();
        }
    }
});

// When typing in the party-id field, highlight the first suggestion
$('#party-id').on('input', function() {
    showSuggestions();
    $('#suggestions .suggestion-item').removeClass('selected');
});
