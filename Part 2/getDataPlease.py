import requests
import csv

# Do pip install requests command in terminal to access requests

# My rawg.io API key
API_KEY = '0dff97a9e2fb46049d15f6943f198f97'

# Define the place
place = "http://api.rawg.io/api/games"

yearlyMetacriticTotal = [0] * 21;

def getYearlyGames(year):
    params = {
        "key": API_KEY,
        "page_size": 40,
        "dates": f"{year}-01-01,{year}-12-31", # first day to last day or arbitrary year
        "ordering": "-Popularity"
    }

    response = requests.get(place, params) # Sends the information request
    return response.json()["results"] # Returns the information stored in a list

# Method to see if the game is multiplayer
def isMultiplayer(game):
    # save them in list
    tags = [tag['name'].lower() for tag in game.get('tags',[])]

    return 'multiplayer' in tags


fileName = 'video game data.csv'

# All of the code should happen in the file.
with open(fileName, 'w', newline='') as csvfile:
    header = ["Year", "Name", "ESRB", "Metacritic", "Playtime", "Genre", "Multiplayer?"]
    writer = csv.DictWriter(csvfile, header)

    # Make the header to set data format
    writer.writeheader()

    # For ever year
    for year in range(2024, 2003, -1):

        yearCount = year - 2004;

        # Hold the year's games
        games = getYearlyGames(year)

        # Write each games information in the correct order
        for game in games:

            metacriticScore = game.get('metacritic', None)

            # This writes them comma sep
            writer.writerow({
                "Year": year,
                "Name": game["name"],
                "ESRB": game.get('esrb_rating', {}).get('name', 000) if game.get('esrb_rating') else "NA",
                "Metacritic": game.get('metacritic') if game.get('metacritic') else 000,
                "Playtime": game.get('playtime', None), # This will be 0 only if it says os
                "Genre": game.get('genres', [])[0]['name'] if game.get('genres', []) else 000,
                "Multiplayer?": isMultiplayer(game)
            })

            if (metacriticScore is not None):
                yearlyMetacriticTotal[yearCount] += int(metacriticScore);

print(yearlyMetacriticTotal); # Show in the python console
