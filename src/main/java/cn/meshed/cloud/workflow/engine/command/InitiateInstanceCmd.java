package cn.meshed.cloud.workflow.engine.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Map;

/**
 * <h1>启动流程实例</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Data
@Schema(description = "启动流程实例")
public class InitiateInstanceCmd implements Serializable {

    /**
     * 流程标识
     */
    @Schema(description = "流程标识")
    @NotBlank(message = "流程标识不能为空")
    private String key;
    /**
     * 携带参数
     */
    @Schema(description = "携带参数")
    private Map<String, Object> param;
}
