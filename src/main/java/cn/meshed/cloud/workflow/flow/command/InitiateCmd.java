package cn.meshed.cloud.workflow.flow.command;

import com.alibaba.cola.dto.Command;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * <h1>启动流程实例</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Schema(description = "发起流程")
public class InitiateCmd extends Command {

    /**
     * 流程标识
     */
    @Schema(description = "流程标识")
    @NotBlank(message = "流程标识不能为空")
    private String formKey;
    /**
     * 携带参数
     */
    @Schema(description = "携带参数")
    private Map<String, Object> param;
}