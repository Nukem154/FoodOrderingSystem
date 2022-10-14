import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lunch {
    private CuisineTypeEnum cuisineType;
    private MainCourse mainCourse;
    private Desert desert;
}
