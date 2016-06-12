	
	// A small program for shifting all the matrix's sides to the right
	
	static int[][] shiftMatrix(int[][]inputMatrix){
		int i = inputMatrix.length;
		int j = inputMatrix[0].length;
		
		int temp = 0; int temp2=inputMatrix[0][0];
		
		for (int j2 = 1; j2 < j; j2+=2) {
			
			temp = inputMatrix[0][j2];
			inputMatrix[0][j2]=temp2;
			
			
			temp2 = inputMatrix[0][j2+1];
			inputMatrix[0][j2+1]=temp;
			
			
		}
		
		
		for (int x = 1; x < i; x+=2) {
			
			temp=inputMatrix[x][j-1];
			inputMatrix[x][j-1]=temp2;
			
			temp2 = inputMatrix[x+1][j-1];
			inputMatrix[x+1][j-1]=temp;
			
		}
		
		for (int u = j-2; u > 0; u-=2) {
			
			temp = inputMatrix[i-1][u];
			inputMatrix[i-1][u]=temp2;
			
			
			temp2 = inputMatrix[i-1][u-1];
			inputMatrix[i-1][u-1]=temp;
			
			
		}
		
		for (int v = i-2; v > 0; v-=2) {
			
			temp = inputMatrix[v][0];
			inputMatrix[v][0]=temp2;
			
			
			temp2 = inputMatrix[v-1][0];
			inputMatrix[v-1][0]=temp;
			
			
		}
				
		
		return inputMatrix;
	}
	
	
	
