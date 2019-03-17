package com.ocadohackathon.quizgame;

import com.ocadohackathon.quizgame.game.InMemoryQuestionAnswerRepository;
import com.ocadohackathon.quizgame.game.QuizGame;
import com.ocadohackathon.quizgame.models.PlayerOneController;
import com.ocadohackathon.quizgame.models.PlayerTwoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuizgameApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizgameApplication.class, args);
	}

	@Bean
	public QuizGame startNewGame() {
		return new QuizGame(new PlayerOneController(0,0,0),
				new PlayerTwoController(0,0,0),
				new InMemoryQuestionAnswerRepository());
	}

	@Bean
	public Integer xAxis() {
		return 0;
	}

	@Bean
	public Integer yAxis() {
		return 0;
	}

	@Bean
	public Integer button() {
		return 1;
	}

	@Bean
	public InMemoryQuestionAnswerRepository getRepository() {
		return new InMemoryQuestionAnswerRepository();
	}
}
