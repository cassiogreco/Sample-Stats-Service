package presentation;

import application.StatsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatsController {
    private StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<String> GetStats() {
        Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
        return ResponseEntity.ok(gson.toJson(this.statsService.getStats()));
    }
}
