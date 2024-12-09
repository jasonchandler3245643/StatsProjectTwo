import requests
import csv

# Do pip install requests command in terminal to access requests

# My rawg.io API key
API_KEY = '0dff97a9e2fb46049d15f6943f198f97'

# Define the place
url = "http://api.rawg.io/api/games"

yearlyMetacriticTotal = [0] * 21;

esrbCounts = []
yearlyEsrbCounts = [];

def getYearlyGames(year):
    params = {
        "key": API_KEY,
        "page_size": 40,
        "dates": f"{year}-01-01,{year}-12-31", # first day to last day or arbitrary year
        "ordering": "-metacritic,-rating" # Filter by 2 metrics of "best" game
    }

    response = requests.get(url, params)
    return response.json()["results"]


def isMultiplayer(game):
    tags = [tag['name'].lower() for tag in game.get('tags',[])]

    return 'multiplayer' in tags


fileName = 'video game data.csv'

with open(fileName, 'w', newline='') as csvfile:
    fieldNames = ["Year", "Name", "ESRB", "Metacritic", "Playtime", "Genre", "Multiplayer?"]
    writer = csv.DictWriter(csvfile, fieldnames=fieldNames)

    # Make the header to set data format
    writer.writeheader()

    # For each year 2024 - 2004
    for year in range(2024, 2003, -1):

        yearCount = year - 2004;
        esrbCounts = [0, 0, 0, 0, 0];  # order: E, E10+, T, M, AO

        # Hold the year's games
        games = getYearlyGames(year)

        # Write each games information in the correct order
        for game in games:

            metacriticScore = game.get('metacritic', None)

            writer.writerow({
                "Year": year,
                "Name": game["name"],
                "ESRB": game.get('esrb_rating', {}).get('name', 000) if game.get('esrb_rating') else 000,
                "Metacritic": game.get('metacritic', None),
                "Playtime": game.get('playtime', None),
                "Genre": game.get('genres', [])[0]['name'] if game.get('genres', []) else 000,
                "Multiplayer?": isMultiplayer(game)
            })

            metacriticScore = game.get('metacritic', None)

            if (metacriticScore is not None):
                yearlyMetacriticTotal[yearCount] += int(metacriticScore);

print(yearlyMetacriticTotal);

# maybe compare esrb ratings, playtime