# Capitaly Game Simulation

This project simulates a simplified version of the Capitaly game. The game involves multiple players with different strategies, moving around a cyclical board with various types of fields. Players roll dice to determine their movement on the board and interact with different types of fields.

## Description

In the Capitaly game, players can encounter three types of fields: property, service, and lucky fields. Here are the rules for each type:

Property: Players can buy properties for 1000 currency. On subsequent visits to the same property, players have the option to build a house for 4000 currency. If a player lands on a property field owned by another player, they must pay 500 currency if no house is built or 2000 currency if there is a house.
Service: Players must pay a specific amount of currency to the bank when they land on a service field. The amount is defined as a parameter of the field.
Lucky: Players receive a certain amount of money when they land on a lucky field. The amount is defined as a parameter of the field.
The game features three different player strategies:

Greedy Player: This player buys unowned properties or their own properties without a house if they have enough money.
Careful Player: This player limits their purchases in a round to at most half of their current money.
Tactical Player: This player skips every second opportunity to buy properties.
If a player runs out of money while paying, they lose the game. In such cases, their properties become available for other players to purchase.

The game parameters, including the number and types of fields, players' strategies, and dice rolls, are read from a text file. The program determines the winner based on the game's progression and prints the winner's information, including type, name, balance, and owned properties.

## Usage

The program consists of the following classes and methods:

📂 Program.java

👤 Program:
- 📝 `Program(String filename)`: Constructs a program object with the provided filename.
- 📝 `run()`: Runs the program to determine the winner and prints their data to the console.
- 📝 `progToString()`: Returns the winner's data as a string.

📂 Capitaly.java

👤 Capitaly:
- 📝 `Capitaly(ArrayList<Field> circuit, ArrayList<Player> players, ArrayList<Integer> rolls)`: Constructs a Capitaly game with the given circuit, players, and dice rolls.
- 📝 `getCircuit()`: Returns the circuit (board) of the game.
- 📝 `getPlayers()`: Returns the list of players in the game.
- 📝 `getRolls()`: Returns the list of dice rolls.
- 📝 `isLastWinner(Player p)`: Checks whether a player `p` is the last winner.
- 📝 `cleanUp()`: Clears the circuit, players, and rolls lists to end the game.
- 📝 `doEvent()`: Executes the rounds of the game.
- 📝 `getWinnerString()`: Returns the winner's information as a string.

👤 Player:
- 📝 `getName()`: Returns the name of the player.
- 📝 `Player(String name)`: Constructs a player object with the provided name.
- 📝 `getFields()`: Returns the fields owned by the player.
- 📝 `getPos()`: Returns the player's position on the board.
- 📝 `getBalance()`: Returns the player's balance (amount of money).
- 📝 `getInGame()`: Returns whether the player is still in the game.
- 📝 `getType()`: Returns the type of the player.
- 📝 `buy(Property f)`: Buys a property (implementation specific to player strategies).
- 📝 `setMoney(int amount)`: Sets the player's balance to the specified amount.
- 📝 `addField(Field field)`: Adds a field to the player's ownership.
- 📝 `removeField()`: Removes all owned fields.
- 📝 `move(int amount)`: Moves the player on the board by the specified amount.
- 📝 `pay(Player player, int amount)`: Deducts the specified amount from the player's balance as payment to another player.
- 📝 `print()`: Prints the player's data to the console.
- 📝 `printString()`: Returns the player's data as a string.
- 📝 `doEvent(Field f)`: Executes specific actions based on the given field type.

📂 Field.java

👤 Field:
- 📝 `Field(String name, int pos, int value, boolean buyable)`: Constructs a field with the given properties.
- 📝 `getPos()`: Returns the position of the field on the board.
- 📝 `getName()`: Returns the name of the field.
- 📝 `getBuyable()`: Returns whether the field is buyable.
- 📝 `getValue()`: Returns the value of the field.
- 📝 `getType()`: Returns the type of the field.
- 📝 `print()`: Prints the field's data.
- 📝 `getOwner()`: Returns the owner of the field.
- 📝 `removeOwner()`: Removes the owner of the field.
- 📝 `setBuyable(boolean b)`: Sets the buyability of the field.
- 📝 `removeField()`: Removes the field.
- 📝 `isHouseBought()`: Checks if a house is bought for the property.
