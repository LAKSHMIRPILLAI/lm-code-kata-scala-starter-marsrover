package com.techreturners


import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class AppTest extends AnyFlatSpec with Matchers{

   val marsPlateau =new MarsPlateau(5,5)
   val marsRover=new MarsRover(1,1,"N")
  "A Mars plateau "should "be Rectangle or square of given size" in {
    assert(marsPlateau.plateauX==5)
    assert(marsPlateau.plateauY==5)
  }
  "A Mars Rover "should "have an initial point and direction" in {
    assert(marsRover.initialPositionX ==1)
    assert(marsRover.initialPositionY ==1)
    assert(marsRover.initialDirection=="N")
  }
  "A Mars Rover "should "have initial starting position within the plateau" in {
    val marsPlateau =new MarsPlateau(5,5)
    val marsRover=new MarsRover(1,1,"N")
    assert(marsRover.validRoverPosition==true)
  }
  "A Mars Rover "should "turn direction from North to West while turning left" in {
    val marsRover1 = new MarsRover(1, 1, "N")
    marsRover1.roverCommands("L")
    assert(marsRover1.lastDirection == "W")
  }
  "A Mars Rover "should "turn direction from South to East while turning left" in {
    val marsRover2 = new MarsRover(1, 1, "S")
    marsRover2.roverCommands("L")
    assert(marsRover2.lastDirection == "E")
  }
  "A Mars Rover "should "turn direction from East to North while turning left" in {
    val marsRover3 = new MarsRover(1, 1, "E")
    marsRover3.roverCommands("L")
    assert(marsRover3.lastDirection == "N")
  }
  "A Mars Rover "should "turn direction from West to South while turning left" in {
    val marsRover4=new MarsRover(1,1,"W")
    marsRover4.roverCommands("L")
    assert(marsRover4.lastDirection=="S")
   }
  "A Mars Rover "should "turn direction from North to East while turning right" in {
    val marsRover1 = new MarsRover(1, 1, "N")
    marsRover1.roverCommands("R")
    assert(marsRover1.lastDirection == "E")
  }
  "A Mars Rover "should "turn direction from South to West while turning right" in {
    val marsRover2 = new MarsRover(1, 1, "S")
    marsRover2.roverCommands("R")
    assert(marsRover2.lastDirection == "W")
  }
  "A Mars Rover "should "turn direction from East to South while turning right" in {
    val marsRover3 = new MarsRover(1, 1, "E")
    marsRover3.roverCommands("R")
    assert(marsRover3.lastDirection == "S")
  }
  "A Mars Rover "should "turn direction from West to North while turning right" in {
    val marsRover4=new MarsRover(1,1,"W")
    marsRover4.roverCommands("R")
    assert(marsRover4.lastDirection=="N")
  }
  "A Mars Rover "should "move one step  in a given direction if provided with a M command if facing North" in {
  val marsRover=new MarsRover(1,1,"N")
  marsRover.roverCommands("M")
  assert(marsRover.positionX==1)
  assert(marsRover.positionY==2)
}
  "A Mars Rover "should "move one step  in a given direction if provided with a M command if facing East " in {
    val marsRover=new MarsRover(1,1,"E")
    marsRover.roverCommands("M")
    assert(marsRover.positionX==2)
    assert(marsRover.positionY==1)
  }

  "A Mars Rover "should "move one step  in a given direction if provided with a M command if facing West " in {
    val marsRover=new MarsRover(4,4,"W")
    marsRover.roverCommands("M")
    assert(marsRover.positionX==3)
    assert(marsRover.positionY==4)
  }
  "A Mars Rover "should "move one step  in a given direction if provided with a M command if facing South " in {
    val marsRover=new MarsRover(4,4,"S")
    marsRover.roverCommands("M")
    assert(marsRover.positionX==4)
    assert(marsRover.positionY==3)
  }
  "A Mars Rover "should "move as per the command passed " in {
    val marsRover=new MarsRover(1,2,"N")
    marsRover.roverCommands("LMLMLMLMM")
    assert(marsRover.positionX==1)
    assert(marsRover.positionY==3)
    assert(marsRover.lastDirection=="N")
  }
  "A Mars Rover "should "move as per the string of command passed " in {
    val marsRover=new MarsRover(3,3,"E")
    marsRover.roverCommands("MMRMMRMRRM")
    assert(marsRover.positionX==5)
    assert(marsRover.positionY==1)
    assert(marsRover.lastDirection=="E")
  }
}
