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
  


### Syscalls
#####0. [SC\_Halt](#sc_halt) 
Stop Nachos, and print out performance stats
#####1. [SC\_Exit](#sc_exit) 
This user program is done (status = 0 means exited normally).
#####2. [SC\_Exec](#sc_exec)  
Run the executable, stored in the Nachos file "name", in the context of the current address space. Should not return unless there is an error, in which case a -1 is returned.
#####3. [SC\_Join](#sc_join)  
Only return once the the user program "id" has finished.  Return the exit status.
#####4. [SC\_Create](#sc_create)  
Create a Nachos file, with "name" 
#####5. [SC\_Open](#sc_open)  
Open the Nachos file "name", and return an "OpenFileId" that can be used to read and write to the file.
#####6. [SC\_Read](#sc_read)  
Read "size" bytes from the open file into "buffer".  Return the number of bytes actually read -- if the open file isn't long enough, or if it is an I/O device, and there aren't enough characters to read, return whatever is available (for I/O devices, you should always wait until you can return at least one character).
#####7. [SC\_Write](#sc_write)  
Write "size" bytes from "buffer" to the open file.
#####8. [SC\_Close](#sc_close)  
Close the file, we're done reading and writing to it.
#####9. [SC\_Fork](#sc_fork)  
Fork creates a clone (the child) of the calling user process (the parent). The parent gets the SpaceId of the child as the return value of the Fork; the child gets a 0 return value. If there is an error that prevents the creation of the child, the parent gets a -1 return value.
#####10. [SC\_Dup](#sc_dup)  
Returns a new OpenFileId referring to the same file as denoted by the argument


For all syscalls that necessitate reading as an argument, we read the string out of the appropriate register and place it in a buffer called stringArg.  The buffer has a size of 128 characters.  We allow the user to input up to 127 characters, the 128th character is always forcibly a null character.  This way if a user gives an input string for an argument that is longer than 127 characters it is simply truncated to 127 characters.
