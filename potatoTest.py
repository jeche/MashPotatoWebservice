import requests
import time
from requests.auth import HTTPBasicAuth
# Clear users

# Add atjones try first time.  Fails because first it has to recreate admin user.
url = 'http://gentle-retreat-6423.herokuapp.com/addUser'
payload = {'userName': 'atjones', 'id':'atjones', 'firstName':'A', 'lastName':'J', 'hashedPassword':'test1'}
#print("Adding the user " + payload['userName'] +" to the database using " + url + " password is: " + payload['hashedPassword'])
request = requests.post(url, data=payload, auth=HTTPBasicAuth('admin', 'admin'))

# Add atjones
url = 'http://gentle-retreat-6423.herokuapp.com/addUser'
payload = {'userName': 'atjones', 'id':'atjones', 'firstName':'A', 'lastName':'J', 'hashedPassword':'test1'}
print("Adding the user " + payload['userName'] +" to the database using " + url + " password is: " + payload['hashedPassword'])
request = requests.post(url, data=payload, auth=HTTPBasicAuth('admin', 'admin'))
print(request.text)
