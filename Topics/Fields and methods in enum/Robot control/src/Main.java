class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {

        int xdir = toX - robot.getX();
        int ydir = toY - robot.getY();

        if(xdir == 0 && ydir == 0 ) {
            return;
        }
        else if(xdir > 0 ) {
            if(Direction.RIGHT == robot.getDirection()) {
                robot.stepForward();
                moveRobot(robot,toX,toY);
            }
            else {
                robot.turnRight();
                moveRobot(robot,toX,toY);
            }
        }
        else if(xdir < 0 ) {
            if (Direction.LEFT == robot.getDirection()) {
                robot.stepForward();
                moveRobot(robot,toX,toY);
            }
            else {
                robot.turnRight();
                moveRobot(robot,toX,toY);
            }
        }
        else  if (ydir > 0 ){
            if(Direction.UP == robot.getDirection()) {
                robot.stepForward();
                moveRobot(robot,toX,toY);
            }
            else {
                robot.turnRight();
                moveRobot(robot,toX,toY);
            }
        }
        else if(ydir < 0) {
            if (Direction.DOWN == robot.getDirection()) {
                robot.stepForward();
                moveRobot(robot,toX,toY);
            }
            else {
                robot.turnRight();
                moveRobot(robot,toX,toY);
            }
        }



    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}