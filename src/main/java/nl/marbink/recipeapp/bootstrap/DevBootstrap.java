package nl.marbink.recipeapp.bootstrap;

import nl.marbink.recipeapp.domain.Difficulty;
import nl.marbink.recipeapp.domain.Recipe;
import nl.marbink.recipeapp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;

    @Autowired
    public DevBootstrap(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Recipe one = new Recipe();
        one.setDescription("one");
        one.setDifficulty(Difficulty.EASY);
        one.setCookTime(100);

        Recipe two = new Recipe();
        two.setDescription("two");
        two.setDifficulty(Difficulty.EASY);
        two.setCookTime(100);

        recipeRepository.save(one);
        recipeRepository.save(two);
    }
}
