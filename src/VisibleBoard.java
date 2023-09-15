public class VisibleBoard {
		public String[][] visibleBoard = new String[9][9];
public String hitEmoji = " 💥 ";
public String missEmoji = " ❌ ";
public String wave = " 🌊 ";



		public String[][] setupBoard() {
				for (int i = 0; i < visibleBoard.length; i++) {
						for (int j = 0; j < visibleBoard[0].length; j++) {
								visibleBoard[i][j] = wave;
						}
				}
				return visibleBoard;
		}

		public void printBoard() {
				for (int i = 0; i < visibleBoard.length; i++) {
						for (int j = 0; j < visibleBoard[0].length; j++) {
								System.out.print(visibleBoard[i][j]);
						}
						System.out.println();
				}
		}

		public void markHit(int col, int row) {
				visibleBoard[row][col] = hitEmoji;
		}

		public void markMiss(int col, int row) {
				visibleBoard[row][col] = missEmoji;
		}
}
