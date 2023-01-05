package me.tokan.recipesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FirstController {

	@GetMapping

	public String recipesProject(){
		return "Приложение запущено";
	}
	@GetMapping("/info")

	public String info(){
		return "Имя ученика: Токан Екатерина Сергеевна," +
				" Название проекта: <Веб приложение для рецептов.>," +
				" Дата создания проекта: 5.01.2023," +
				" Описание проекта: <Разработка веб приложения для чтения и внесения рецептов.>";
	}
}
