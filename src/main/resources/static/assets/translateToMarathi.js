function translateToMarathi() {
            // Get the English inputs
            const firstNameEn = document.getElementById('firstname').value;
            const middleNameEn = document.getElementById('middlename').value;
            const surnameEn = document.getElementById('surname').value;

            const url = '/translate'; // Local Spring Boot endpoint

            // Prepare the request data
            const requestData = {
                firstname: firstNameEn,
                middlename: middleNameEn,
                surname: surnameEn
            };

            // Send a POST request to the backend
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(requestData)
            })
            .then(response => response.json())
            .then(data => {
                // Set the Marathi input fields
                document.getElementById('first-name-hi').value = data.translatedFirstName || '';
                document.getElementById('middle-name-hi').value = data.translatedMiddleName || '';
                document.getElementById('surname-hi').value = data.translatedSurname || '';
            })
            .catch(error => {
                console.error('Error during translation:', error);
            });
        }