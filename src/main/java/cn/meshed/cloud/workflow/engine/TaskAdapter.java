package cn.meshed.cloud.workflow.engine;

import cn.meshed.cloud.workflow.engine.command.AttachmentCmd;
import cn.meshed.cloud.workflow.engine.command.CommentCmd;
import cn.meshed.cloud.workflow.engine.command.CompleteTaskCmd;
import cn.meshed.cloud.workflow.engine.data.AttachmentDTO;
import cn.meshed.cloud.workflow.engine.data.CommentDTO;
import cn.meshed.cloud.workflow.engine.data.TaskActivityDTO;
import cn.meshed.cloud.workflow.engine.data.TaskDTO;
import cn.meshed.cloud.workflow.engine.query.TaskActivityQry;
import cn.meshed.cloud.workflow.engine.query.TaskPageQry;
import cn.meshed.cloud.workflow.engine.query.TaskQry;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * <h1>任务适配器</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@RequestMapping("/task")
public interface TaskAdapter {

    /**
     * 任务列表
     *
     * @param taskPageQry 任务分页查询参数
     * @return {@link PageResponse < DefinitionDTO >}
     */
    @Operation(summary = "任务列表")
    @GetMapping("/list")
    PageResponse<TaskDTO> list(@Parameter(description = "任务分页查询参数") @Valid TaskPageQry taskPageQry);

    /**
     * 任务信息
     *
     * @param taskQry 任务查询参数
     * @return {@link SingleResponse < DefinitionDTO >}
     */
    @Operation(summary = "任务信息")
    @GetMapping("/query")
    SingleResponse<TaskDTO> query(@Parameter(description = "任务查询参数") @Valid TaskQry taskQry);

    /**
     * 任务历史活动节点列表
     *
     * @param taskActivityQry 任务活动查询
     * @return {@link PageResponse < TaskActivityDTO >}
     */
    @Operation(summary = "任务历史活动节点列表")
    @GetMapping("/activity/record/list")
    MultiResponse<TaskActivityDTO> activityList(@Parameter(description = "任务活动查询") TaskActivityQry taskActivityQry);

    /**
     * 审批同意
     *
     * @param completeTaskCmd 完成参数
     * @return {@link Response}
     */
    @Operation(summary = "审批同意")
    @PostMapping("/agree")
    Response agree(@Parameter(description = "销毁实例参数") @RequestBody @Valid CompleteTaskCmd completeTaskCmd);

    /**
     * 审批拒绝
     *
     * @param completeTaskCmd 完成参数
     * @return {@link Response}
     */
    @Operation(summary = "审批拒绝")
    @PostMapping("/refuse")
    Response refuse(@Parameter(description = "销毁实例参数") @RequestBody @Valid CompleteTaskCmd completeTaskCmd);

    /**
     * 添加评论
     *
     * @param commentCmd 评论信息
     * @return {@link Response}
     */
    @Operation(summary = "添加评论")
    @PostMapping("/make/comment")
    Response makeComment(@Parameter(description = "销毁实例参数") @RequestBody @Valid CommentCmd commentCmd);

    /**
     * 根据任务ID查询评论
     *
     * @param instanceId 实例ID
     * @return {@link MultiResponse<CommentDTO>>}
     */
    @Operation(summary = "")
    @GetMapping("get/comments/{instanceId}")
    MultiResponse<CommentDTO> getComments(@Parameter(description = "实例ID") @PathVariable("instanceId") String instanceId);

    /**
     * 删除评论
     *
     * @param commentId 评论ID
     * @return {@link Response}
     */
    @Operation(summary = "删除评论")
    @PostMapping("/del/comment/{commentId}")
    Response delComment(@Parameter(description = "评论ID") @PathVariable("commentId") String commentId);

    /**
     * 添加附件
     *
     * @param attachmentCmd 添加附件参数
     * @return {@link Response}
     */
    @Operation(summary = "添加附件")
    @PostMapping("/add/attachment")
    Response addAttachment(@Parameter(description = "销毁实例参数") @RequestBody @Valid AttachmentCmd attachmentCmd);

    /**
     * 获取实例附件
     *
     * @param instanceId 实例ID
     * @return {@link MultiResponse<AttachmentDTO>}
     */
    @Operation(summary = "获取实例附件")
    @GetMapping("get/attachments/{instanceId}")
    MultiResponse<AttachmentDTO> getAttachments(@Parameter(description = "实例ID") @PathVariable("instanceId") String instanceId);

    /**
     * 删除附件
     *
     * @param attachmentId 附件ID
     * @return {@link Response}
     */
    @Operation(summary = "删除附件")
    @PostMapping("/del/attachment/{attachmentId}")
    Response delAttachment(@Parameter(description = "附件ID") @PathVariable("attachmentId") String attachmentId);
}
