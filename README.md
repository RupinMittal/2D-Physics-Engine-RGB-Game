# RGB-FinalProject

### Description

This was a group project in Java for my AP Computer Science class. It is platform game with a physics engine build from scratch, menu and player GUI, and graphics and music integration. 

The following concepts were implemented:

* Object-Oriented Programming
* Linking Multiple Java Files
* Interfaces + Polymorphism
* Inheritance
* Public/Private methods
* JavaFX + Graphical User Interface (GUI)
* Custom Graphics/Image generation + Pixel manipulation
* Custom Music integration
* User Input/Output with Menus and buttons
* File Input/Output
* Multi-dimensional arrays
* Random Generation
* Handling of Player's Physics

This project creates a JavaFX application and creates a platform game with levels for the user to play on, 
menus for user to choose various options like music, volume, their character, screen size. The program moves throughout the game, 
with the screen following the user's movements. The premise of the game is that the player has to make it out 
of the rooms they are stuck in. Lining the paths in front of them, are red, green, and blue walls. Hitting a red wall kills you, 
a blue wall acts like a trampoline, and you can stick to green walls. Use jumping, running, walking, and your skills to make it 
through all the levels. 

### How to run the progam and play

1. Make a folder to hold the repository
2. Clone the project: ```% git clone https://github.com/RupinMittal/RGB-FinalProject.git```
3. Make sure you have Java and JavaFX installed
4. Compile and run the code. The main (start) method is the MainMenu.java file.

### A GIF of the Game in play (the end of the README has still images)

//put GIF 

### How it works

*Generating the Levels*

Different .png files were created for each of the blocks. A software called Tiled was used to organize the blocks 
into positions to make the final png for each sector/level. The innovative part is that a array was created with a different 
numerical value for each of the blocks. For example a block with an upwards facing red wall could have a value of 1, and an 
upwards facing blue wall could have a value of 2. Such values were created for every block in the game. Since each sector has it's 
own png file, a collisionArray was generated containing the values organized in the same order as in the image. 

*The Physics Engine and moving the Player*

Since the pixel length and width of each block is known, based on the position of the image of the player, it is determined if the player 
is colliding with a wall or not. Based on the collision status and the type of block being interacted with, the appropriate reaction 
is performed and animated. The collisionArray is heavily relied on. For the friction and gravity, arbitrary numbers were assigned to calculate 
the acceleration due to gravity and the normal force. This allows for realistic movements. It should also be highlighted that the when moving 
side to side, the player does not instantly reach top speed or stop, since friction is applied. This adds to the realistic movements.

The arrow keys are used for moving the player. The JavaFX library was used for this. An event handler was created to call 
appropriate functions for the different arrows. And an animation timer was used to time the display of the image. 

When playing the game it is noticeable that when the player moves, it is not just a picture of a player being dragged across the 
screen, rather there is animation of the action of running and jumping. This effect is created by generating a set of images, a different one
for each snapshot of a person's position in a cycle of running. Different images are displayed based on the time in the running, and this 
makes it look like a real person running with moving arms and legs. 

*Moving the Screen and loading Images*

The JavaFX library was used to display the many images in the game. So the ImageView, Geometry, Image, Event, Position, Layout, Blur, Stage, ToggleButton, 
and more classes were used to display the image of the sector, superimpose the image of the player and move the player. One important 
element of this project was moving the screen along the sector as the player moved. So the screen was moved in the created window 
relative to the user's position. While the user was in a certain range in the middle, the screen did not move, towards the edges, the 
screen was moved accordingly.

When the player finishes one of the sectors/levels, the next sector is displayed, and a victory screen is shown after all the levels are complete.

*The Menus*

For the Menus, similar classes from the JavaFX library were used to create the menu. Special graphics were used to make custom images of the buttons, 
signs/labels, colors, and backgrounds for the menu screens. The initial menu displayed allows the user to see the game backstory, 
the credits, how to play instructions, choose their character to play with, volume of the music and start the game. There are submenus according to 
the these actions. 

### Structure of the Project


### The Program in Action
