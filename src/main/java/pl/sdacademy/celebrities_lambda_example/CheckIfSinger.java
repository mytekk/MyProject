package pl.sdacademy.celebrities_lambda_example;

public class CheckIfSinger implements CheckTalent {

	@Override
	public boolean test(Celebrity celebrity) {
		return celebrity.canSing();
	}

}
