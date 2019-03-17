package com.ocadohackathon.quizgame;

import com.ocadohackathon.quizgame.game.QuizGame;
import com.ocadohackathon.quizgame.models.PlayerOneController;
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
		return new QuizGame();
	}

}
