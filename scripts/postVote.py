import requests
from requests.auth import HTTPBasicAuth
url = 'http://secure-lake-6285.herokuapp.com/players/kill'
 
# Specify the url
url = 'http://secure-lake-6285.herokuapp.com/players/vote'
payload = {'voted': 'jlchen'}
# Makes request
request = requests.post(url, data=payload, auth=HTTPBasicAuth('atjones', 'test1'))
 
# Print out return value, should return success.
print request.text