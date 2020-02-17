package app;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest.TileManager;

import java.io.IOException;

@RestController
public class HelloController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    TileManager tileManager;

    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

    @RequestMapping("/{z}/{x}/{y}")
    public byte[] getTile(@PathVariable("z") int z, @PathVariable("x") long x, @PathVariable("y") long y) throws IOException {
        return tileManager.getTile(z, x, y);
    }

    @Data
    static class Result {
        private final int left;
        private final int right;
        private final long answer;

        Result(int left, int right, long answer) {
            this.left = left;
            this.right = right;
            this.answer = answer;
        }
    }

    // SQL sample
    @RequestMapping("calc")
    Result calc(@RequestParam int left, @RequestParam int right) {
        MapSqlParameterSource source = new MapSqlParameterSource()
                .addValue("left", left)
                .addValue("right", right);
        return jdbcTemplate.queryForObject("SELECT :left + :right AS answer", source,
                (rs, rowNum) -> new Result(left, right, rs.getLong("answer")));
    }
}
