package chess;

public class CheckInput {
	

	public boolean checkCoordinateValidity(String input){
		if(input.length() != 2){
			return false;
		}
		if(!Character.isDigit(input.charAt(0))){
			return false;
		}
		else if(Character.getNumericValue(input.charAt(0)) > 8 ||Character.getNumericValue(input.charAt(0)) < 1){
			return false;
		}
		if(!Character.isAlphabetic(input.charAt(1))){
			return false;
		}
		else if(input.charAt(1) > 'h'){
			return false;
		}
		return true;
	}
}
