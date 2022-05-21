package com.techreturners
class MarsPlateau(x:Int,y:Int){
  val plateauX:Int =x
  val plateauY:Int =y
}

class MarsRover(initX:Int,initY:Int,initDirection:String) {
  val plateau = new MarsPlateau(5, 5)
  val initialPositionX: Int = initX
  val initialPositionY: Int = initY
  val initialDirection: String = initDirection
  var lastDirection: String = initDirection
  var positionX: Int = initX
  var positionY: Int = initY
  val validRoverPosition: Boolean = checkRoverPosition(plateau.plateauX, plateau.plateauY, initialPositionX, initialPositionY)

  def checkRoverPosition(plateauX: Int, plateauY: Int, roverX: Int, roverY: Int): Boolean = {
    if ((plateauX >= roverX) && (plateauY >= roverY)) true else false
  }

  def roverCommands(commands: String): Unit = {
    val listOfCommands: List[Char] = commands.toList

    listOfCommands.foreach(commandLetter => {
      commandLetter match {
        case 'L' if commandLetter == 'L' => lastDirection = turnLeft(lastDirection)
        case 'R' if commandLetter == 'R' => lastDirection = turnRight(lastDirection)
        case 'M' if commandLetter == 'M' => moveTheRover(lastDirection)

      }

    })
  }

  def turnLeft(lastDirection: String): String = {
    var currentDirection: String = lastDirection
    currentDirection match {
      case "N" => currentDirection = "W"
      case "S" => currentDirection = "E"
      case "E" => currentDirection = "N"
      case "W" => currentDirection = "S"

    }
    currentDirection
  }

  def turnRight(lastDirection: String): String = {
    var currentDirection: String = lastDirection
    currentDirection match {
      case "N" => currentDirection = "E"
      case "S" => currentDirection = "W"
      case "E" => currentDirection = "S"
      case "W" => currentDirection = "N"

    }
    currentDirection
  }

  def moveTheRover(lastDirection: String)={
    lastDirection match {
      case "N" => positionY = positionY+1
      case "S" => positionY = positionY-1
      case "E" => positionX = positionX+1
      case "W" => positionX = positionX-1
    }
  }
}