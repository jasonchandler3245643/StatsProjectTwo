import requests
import csv

# Do pip install requests command in terminal to access requests

# My rawg.io API key
API_KEY = '0dff97a9e2fb46049d15f6943f198f97'

# Define the place
url = "http://api.rawg.io/api/games"

# Then the paramaters
params = {
    "key": API_KEY,
    "page_size": 1,
    "ordering": "-rating" # To make the top 100 the first 100 on the page
}

# Now use requests to fetch the data
response = requests.get(url, params)

# If the HTTP request is successful

if (response.status_code == 200):
    data = response.json()
    games = data.get('results', [])

    fileName = 'video game data.csv'

    with open(fileName, 'w', newline='') as csvfile:
        fieldNames = ['name', 'rank','score', 'genre', 'year']
        writer = csv.DictWriter(csvfile, fieldnames=fieldNames)

        # Make the header to set data format
        writer.writeheader()

        for game in games:
            writer.writerow({
                'name': game.get('name'),
                'rank': game.get('position', None),
                "score": game.get('metacritic', None),  # Score, None if not available
                "genre": ', '.join([genre['name'] for genre in game.get('genres', [])]),
                'year': game.get('released').split('-')[0]

            })




else:
    print("flop")