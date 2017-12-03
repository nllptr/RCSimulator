HOW TO RUN:
===========
Alternative 1: Open the Eclipse project and run.
Alternative 2: Run the jar file available as a release on GitHub.

NOTES:
======
The assignment text says that "The company has a wide range of cars,
Monster Trucks, Off-road and Sport track, but for now they only want
to simulate the Monster Truck". My first thought was to build an abstract
Car class, and let MonsterTruck inherit from it. There are a few
reasons that I have chosen not to do that:

1. This assignment is so small, and implementing the mentioned class
   structure would only contribute to a cluttered file hierarchy.

2. I try to make a point of not abstracting too early. If I had a second
   car type, I might consider it. If I had a third car type I would
   probably understand the domain well enough to understand the consequences
   of my design choices.
