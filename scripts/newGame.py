import requests
import time
from requests.auth import HTTPBasicAuth
# Clear users
url = 'http://secure-lake-6285.herokuapp.com/admin/test'
print("Clearing user database of users: " + url + " credentials are admin, admin")
request = requests.post(url, auth=HTTPBasicAuth('admin', 'admin'))
print("Clearing was: " + request.json()["status"])

# Add atjones try first time.  Fails because first it has to recreate admin user.
url = 'http://secure-lake-6285.herokuapp.com/addUser'
payload = {'userName': 'atjones', 'id':'atjones', 'firstName':'A', 'lastName':'J', 'hashedPassword':'test1'}
#print("Adding the user " + payload['userName'] +" to the database using " + url + " password is: " + payload['hashedPassword'])
request = requests.post(url, data=payload, auth=HTTPBasicAuth('admin', 'admin'))

# Add atjones
url = 'http://secure-lake-6285.herokuapp.com/addUser'
payload = {'userName': 'atjones', 'id':'atjones', 'firstName':'A', 'lastName':'J', 'hashedPassword':'test1'}
print("Adding the user " + payload['userName'] +" to the database using " + url + " password is: " + payload['hashedPassword'])
request = requests.post(url, data=payload, auth=HTTPBasicAuth('admin', 'admin'))
print("Addition was: " + request.json()["status"])

# Add jlchen
url = 'http://secure-lake-6285.herokuapp.com/addUser'
payload = {'userName': 'jlchen', 'id':'jlchen', 'firstName':'A', 'lastName':'J', 'hashedPassword':'test1'}
print("Adding the user " + payload['userName'] +" to the database using " + url + " password is: " + payload['hashedPassword'])
request = requests.post(url, data=payload, auth=HTTPBasicAuth('admin', 'admin'))
print("Addition was: " + request.json()["status"])

# Add aablohm
url = 'http://secure-lake-6285.herokuapp.com/addUser'
payload = {'userName': 'aablohm', 'id':'aablohm', 'firstName':'A', 'lastName':'J', 'hashedPassword':'test1'}
print("Adding the user " + payload['userName'] +" to the database using " + url + " password is: " + payload['hashedPassword'])
request = requests.post(url, data=payload, auth=HTTPBasicAuth('admin', 'admin'))
print("Addition was: " + request.json()["status"])

# Add sychen
url = 'http://secure-lake-6285.herokuapp.com/addUser'
payload = {'userName': 'sychen', 'id':'sychen', 'firstName':'A', 'lastName':'J', 'hashedPassword':'test1'}
print("Adding the user " + payload['userName'] +" to the database using " + url + " password is: " + payload['hashedPassword'])
request = requests.post(url, data=payload, auth=HTTPBasicAuth('admin', 'admin'))
print("Addition was: " + request.json()["status"])

url = 'http://secure-lake-6285.herokuapp.com/admin/newgametest'
print("Starting a new game: " + url + " credentials are admin, admin")
request = requests.post(url, auth=HTTPBasicAuth('admin', 'admin'))
print("Starting was: " + request.json()["status"])

print("atjones is always the werewolf in tests")

#Get all the alive players
url = 'http://secure-lake-6285.herokuapp.com/players/alive'
print("Making sure everyone is alive at url: " + url)
request = requests.get(url, auth=HTTPBasicAuth('admin', 'admin'))
end = "Additions were: "
for item in request.json():
    end = end + item["id"] + " "
end = end + "all of whom are currently alive."
print(end)

print("Waiting one minute until night time to kill sychen")
time.sleep(60)

url = 'http://secure-lake-6285.herokuapp.com/players/kill'
payload = {'victim':'sychen'}
print("Atjones attacking sychen")
# Makes request
request = requests.post(url, data=payload, auth=HTTPBasicAuth('atjones', 'test1'))
print("Attacking sychen " + request.json()["status"])
url = 'http://secure-lake-6285.herokuapp.com/players/alive'
request = requests.get(url, auth=HTTPBasicAuth('admin', 'admin'))
result = "sychen not found in alive players"
for item in request.json():
    if item["id"] == "sychen":
	result = "failed"
print(result)
#time.sleep(60)

# Vote for jlchen to die.
url = 'http://secure-lake-6285.herokuapp.com/players/vote'
payload = {'voted': 'jlchen'}
print("Town is voting for " + payload['voted'])
request = requests.post(url, data=payload, auth=HTTPBasicAuth('aablohm', 'test1'))
print("Vote was done at night so should be failed: " + request.json()["status"])
print("Waiting for day to try again")

time.sleep(60)

url = 'http://secure-lake-6285.herokuapp.com/players/vote'
payload = {'voted': 'jlchen'}
print("Town is voting for " + payload['voted'])
request = requests.post(url, data=payload, auth=HTTPBasicAuth('aablohm', 'test1'))
print("Vote was: " + request.json()["status"])


# Move everyone so that they are not killed by not updating.
url = 'http://secure-lake-6285.herokuapp.com/players/location'
payload = {'lng': '1.0', 'lat': '0.5'}
print("Moving everyone so that they are not killed for lack of updating location")
# Makes request
request = requests.post(url, data=payload, auth=HTTPBasicAuth('aablohm', 'test1'))
print("Moving aablohm " + request.json()["status"])
url = 'http://secure-lake-6285.herokuapp.com/players/location'
payload = {'lng': '1.0', 'lat': '0.5'}
print("Moving everyone so that they are not killed for lack of updating location")
# Makes request
request = requests.post(url, data=payload, auth=HTTPBasicAuth('atjones', 'test1'))
print("Moving atjones " + request.json()["status"])
print("Waiting til night time to kill off jlchen with the most votes")

time.sleep(60)
url = 'http://secure-lake-6285.herokuapp.com/players/alive'
request = requests.get(url, auth=HTTPBasicAuth('admin', 'admin'))
result = "jlchen not found in alive players"
for item in request.json():
    if item["id"] == "jlchen":
	result = "failed"
print(result)

url = 'http://secure-lake-6285.herokuapp.com/players/kill'
payload = {'victim':'aablohm'}
print("Atjones attacking sychen")
# Makes request
request = requests.post(url, data=payload, auth=HTTPBasicAuth('atjones', 'test1'))
print("Attacking aablohm " + request.json()["status"])

url = 'http://secure-lake-6285.herokuapp.com/players/alive'
request = requests.get(url, auth=HTTPBasicAuth('admin', 'admin'))
result = "aablohm not found in alive players"
for item in request.json():
    if item["id"] == "aablohm":
	result = "failed"
print(result)

url = 'http://secure-lake-6285.herokuapp.com/game'
request = requests.get(url, auth=HTTPBasicAuth('admin', 'admin'))
print("Does the number of werewolves exceed townsfolk? " + request.text)