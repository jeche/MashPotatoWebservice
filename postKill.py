

import requests
from requests.auth import HTTPBasicAuth
 
# Specify the url
url = 'http://secure-lake-6285.herokuapp.com/addUser'
payload = {'userName': 'tester', 'id': 'tester', 'firstName':'tester', 'lastName':'tester', 'hashedPassword': 'tester'}
# Makes request
request = requests.post(url, data=payload, auth=HTTPBasicAuth('admin', 'admin'))
 
# Print out return value
print request.text