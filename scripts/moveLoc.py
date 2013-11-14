import requests
from requests.auth import HTTPBasicAuth
 
# Specify the url
url = 'http://secure-lake-6285.herokuapp.com/players/location'
payload = {'lng': '2.0', 'lat': '0'}
# Makes request
request = requests.post(url, data=payload, auth=HTTPBasicAuth('atjones', 'test1'))
 
# Print out return value, should return success.
print request.text

url = 'http://secure-lake-6285.herokuapp.com/players/location'
payload = {'lng': '0', 'lat': '0'}
# Makes request
request = requests.post(url, data=payload, auth=HTTPBasicAuth('jlchen', 'test1'))
print request.text

url = 'http://secure-lake-6285.herokuapp.com/players/location'
payload = {'lng': '1.0', 'lat': '0'}
# Makes request
request = requests.post(url, data=payload, auth=HTTPBasicAuth('aablohm', 'test1'))
print request.text

url = 'http://secure-lake-6285.herokuapp.com/players/location'
payload = {'lng': '1.0', 'lat': '0.5'}
# Makes request
request = requests.post(url, data=payload, auth=HTTPBasicAuth('sychen', 'test1'))
print request.text