package refactoring;

public class Rover {

	public Rover(String facing, int x, int y) {
	}

	public Rover(Heading heading, int x, int y) {
	}

	public static class Position {
		private final int x;
		private final int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Position forward(Heading heading) {
			switch (heading) {
				case North:
					return new Position(x, y + 1);
				case South:
					return new Position(x, y - 1);
				case East:
					return new Position(x + 1, y);
				case West:
					return new Position(x - 1 , y);
			}
			return new Position(x, y);
		}

		public Position backward(Heading heading) {
			switch (heading) {
				case North:
					return new Position(x, y - 1);
				case South:
					return new Position(x, y + 1);
				case East:
					return new Position(x - 1, y);
				case West:
					return new Position(x + 1 , y);
			}
			return new Position(x, y);
		}

		@Override
		public boolean equals(Object object) {
			return isSameClass(object) && equals((Position) object);
		}

		private boolean equals(Position position) {
			return position == this || (x == position.x && y == position.y);
		}

		private boolean isSameClass(Object object) {
			return object != null && object.getClass() == Position.class;
		}

	}


	public enum Heading {
		North, East, South, West;

		public static Heading of(String label) {
			return of(label.charAt(0));
		}

		public static Heading of(char label) {
			if (label == 'N') return North;
			if (label == 'S') return South;
			if (label == 'W') return West;
			if (label == 'E') return East;
			return null;
		}

		public Heading turnRight() {
			return values()[add(+1)];
		}

		public Heading turnLeft() {
			return values()[add(-1)];
		}

		private int add(int offset) {
			return (this.ordinal() + offset + values().length) % values().length;
		}

	}


}
