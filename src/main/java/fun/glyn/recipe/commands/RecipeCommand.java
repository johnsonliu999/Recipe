package fun.glyn.recipe.commands;


import fun.glyn.recipe.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;

    @Size(min = 3, max = 255)
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;

    @URL
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();
    private Byte[] image;
}
