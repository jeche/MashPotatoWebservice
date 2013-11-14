MashPotatoWebservice
========
MashPotatoWebservice

Models
------
Items
  - Multiplier modifier
  - cost
  - player owner

Player
  - Potato Lists
  - Associated with game
  - Everything from the werewolf
  - Items list

Users
  - Same as werewolf, remove images.
  - count of rounds survived over all games
  - count of games won
  - achievements

Game
  - Player lists (remove player from this list when they are out)
  - Game creation date (use for lobby)
  - Round count
  - Potato count
  - additional: enable/disable upgrades/gems
  - int to denote three statesto start, isOver
  - Location of creation
  - list of tuples ("playerName", # round out)

Potato
  - Multiplier
  - Creation Date
  - Holder (Player object)
  - LifeSpan
  - Game
  - Location

DAOs for all models
-------------------
Item
  - multiplier modifiers

Player
  - Get by ID
  - Get by game
  - Get alive by game

Game
  - Get potato holders
  - Get game by player
  - Get games by location that are active
  - Get finished games

Potato
  - Get by game
  - get by player
  - delete by game


Controller
----------
Links needed:
  - Get/Post potato locations & holder status
  - Post addUser
  - Post joinGame
  - Post for Create a Game
  - Get for gameByLocation
  - get playerInfo
  - get to display item/mods
  - post to add mods
  - get players by game
