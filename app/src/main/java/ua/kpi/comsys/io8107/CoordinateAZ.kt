package ua.kpi.comsys.io8107

import java.lang.Exception


enum class Direction {
    N, S, E, W;
}

enum class Type {
    LONGITUDE, LATITUDE
}

fun convertIntoDegMinSec(coordinate: Float): Array<Int> {

    if (coordinate < -180 || coordinate > 180) {
        throw Exception("Coordinate is out of range")
    }

    val unsignedCoord = if (coordinate < 0) {
        -coordinate
    } else {
        coordinate
    }

    val degree = unsignedCoord.toInt()

    val temp: Float = (unsignedCoord - degree) * 60


    var min: Int = temp.toInt()

    if (min < 0) {
        min = min * (-1)
    }
    var sec: Int = ((temp - min) * 60).toInt()

    if (sec < 0) {
        sec = sec * (-1)
    }

    return arrayOf(degree, min, sec)

}

val degPerMin: Float = 1.0f / 60
val degPerSec: Float = 1.0f / 3600

class CoordinateAZ {

    var type: Type? = null

    constructor(direction: Direction, deg: Int, min: Int, sec: Int) {

        this.direction = direction
        if (direction == Direction.N || direction == Direction.S) {
            type = Type.LATITUDE
        } else {
            type = Type.LONGITUDE
        }

        if (checkCoordinate(deg, min, sec, type!!)) {
            throw Exception("This coordinate isn't correct")
        }


        if (direction == Direction.S || direction == Direction.W) {
            this.degree = -deg
            this.minutes = -min
            this.seconds = -sec
        } else {
            this.degree = deg
            this.minutes = min
            this.seconds = sec
        }
    }


    //    Constructor with default initialization
    constructor() {
        this.direction = Direction.N

        if (direction == Direction.N || direction == Direction.S) {
            type = Type.LATITUDE
        } else {
            type = Type.LONGITUDE
        }
        this.degree = 0
        this.minutes = 0
        this.seconds = 0
    }


    var direction: Direction? = null

    var degree: Int = 0
        set(value) {
            when (direction) {

                Direction.N, Direction.S -> {
                    if (value >= -90 && value <= 90) {
                        field = value
                    } else {
                        throw Exception("Degree must be between -90 and 90")
                    }
                }

                Direction.E, Direction.W -> {
                    if (value >= -180 && value <= 180) {
                        field = value
                    } else {
                        throw Exception("Degree must be between -180 and 180")
                    }
                }
            }

        }

    var minutes: Int = 0
        set(value) {
            if (value >= -59 && value <= 59) {
                field = value
            } else {
                throw Exception("Minutes must be specified between 0 and 59")
            }
        }

    var seconds: Int = 0
        set(value) {
            if (value >= -59 && value <= 59) {
                field = value
            } else {
                throw Exception("Seconds must be specified between 0 and 59")
            }
        }


    fun getDecimalValue(): Float {

        val part1: Float = this.minutes * degPerMin
        val part2: Float = this.seconds * degPerSec
        return this.degree + part1 + part2
    }


    fun format1(): String {
        if (this.degree < 0) {
            return "${-this.degree}°${this.minutes}'${this.seconds}'' ${this.direction}"
        }
        return "${this.degree}°${this.minutes}'${this.seconds}'' ${this.direction}"
    }

    fun format2(): String {
        return "${this.getDecimalValue()}...° ${this.direction}"
    }

    fun getMid(coordinate: CoordinateAZ): CoordinateAZ? {
        if (coordinate.type != this.type) {
            return null
        }
        val midValue: Float = (coordinate.getDecimalValue() + this.getDecimalValue()) / 2

        val arr: Array<Int> = convertIntoDegMinSec(midValue)
        val direction: Direction

        if (arr[0] >= 0 && coordinate.type == Type.LONGITUDE) {
            direction = Direction.W

        } else if (arr[0] <= 0 && coordinate.type == Type.LONGITUDE) {
            direction = Direction.E

        } else if (arr[0] >= 0 && coordinate.type == Type.LATITUDE) {
            direction = Direction.N

        } else {
            direction = Direction.S
        }

        return CoordinateAZ(direction, arr[0], arr[1], arr[2])
    }

    companion object {
        fun getMid(coordinate1: CoordinateAZ, coordinate2: CoordinateAZ): CoordinateAZ? {
            if (coordinate1.type != coordinate2.type) {
                return null
            }
            val midValue: Float =
                (coordinate1.getDecimalValue() + coordinate2.getDecimalValue()) / 2

            val arr: Array<Int> = convertIntoDegMinSec(midValue)
            val direction: Direction
            if (arr[0] >= 0 && coordinate1.type == Type.LONGITUDE) {
                direction = Direction.W
            } else if (arr[0] <= 0 && coordinate1.type == Type.LONGITUDE) {
                direction = Direction.E
            } else if (arr[0] >= 0 && coordinate1.type == Type.LATITUDE) {
                direction = Direction.N
            } else {
                direction = Direction.S
            }

            return CoordinateAZ(direction, arr[0], arr[1], arr[2])
        }

        fun checkCoordinate(degrees: Int, minutes: Int, seconds: Int, type: Type): Boolean {
            if (type == Type.LONGITUDE) {

                if (degrees > 180 || degrees < -180) {
                    return false
                }

                if (degrees != 180 && degrees != -180) {

                    if (minutes > 59 || minutes < -59) {
                        return false
                    }
                    if (seconds > 59 || seconds < -59) {
                        return false
                    }


                }

                return true
            }

            if (type == Type.LATITUDE) {
                if (degrees > 90 || degrees < -90) {
                    return false
                }

                if (degrees != 90 && degrees != -90) {

                    if (minutes > 59 || minutes < -59) {
                        return false
                    }
                    if (seconds > 59 || seconds < -59) {
                        return false
                    }


                }

                return true
            }

            return false
        }


    }
}


fun main() {
    val cord = CoordinateAZ(Direction.W, 180, 30, 40)
//    val cord2 = CoordinateAZ(Direction.W, 12, 30, 40)
//    val cord4 = CoordinateAZ.getMid(cord1, cord2)
//    println(cord4?.format1())
}



