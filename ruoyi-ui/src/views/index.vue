<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :span="24">
        <el-card class="role-guide">
          <div slot="header" class="clearfix">
            <span>欢迎使用劳务费报账系统</span>
          </div>
          <div class="guide-content">
            <!-- 教师端指南 -->
            <div v-if="userRole === '教师'" class="role-section">
              <h3><i class="el-icon-user-solid"></i> 教师端功能指南</h3>
              <el-collapse>
                <el-collapse-item title="校外人员信息录入" name="1">
                  <div class="guide-item">
                    <p>用于录入校外合作人员或机构的基本信息：</p>
                    <ul>
                      <li>姓名、身份证号</li>
                      <li>银行卡号、开户行</li>
                      <li>手机号、工作单位</li>
                    </ul>
                  </div>
                </el-collapse-item>
                <el-collapse-item title="劳务费申请" name="2">
                  <div class="guide-item">
                    <p>提交劳务费申请，需填写以下信息：</p>
                    <ul>
                      <li>基本信息（姓名、身份证等）</li>
                      <li>职称职务、发放标准</li>
                      <li>应发金额等</li>
                    </ul>
                  </div>
                </el-collapse-item>
                <el-collapse-item title="账单管理" name="3">
                  <div class="guide-item">
                    <p>管理劳务费账单：</p>
                    <ul>
                      <li>查看劳务费明细</li>
                      <li>复制已有劳务信息</li>
                      <li>跟踪账单状态</li>
                    </ul>
                  </div>
                </el-collapse-item>
              </el-collapse>
            </div>

            <!-- 负责人端指南 -->
            <div v-if="userRole === 'manager'" class="role-section">
              <h3><i class="el-icon-s-check"></i> 负责人端功能指南</h3>
              <el-collapse>
                <el-collapse-item title="劳务费审核" name="1">
                  <div class="guide-item">
                    <p>审核劳务费申请：</p>
                    <ul>
                      <li>核对申请信息完整性</li>
                      <li>审核申请合理性</li>
                      <li>处理审核流程</li>
                    </ul>
                  </div>
                </el-collapse-item>
                <el-collapse-item title="经办人分派" name="2">
                  <div class="guide-item">
                    <p>项目经办人管理：</p>
                    <ul>
                      <li>分配项目经办人</li>
                      <li>管理经办权限</li>
                    </ul>
                  </div>
                </el-collapse-item>
              </el-collapse>
            </div>

            <!-- 财务端指南 -->
            <div v-if="userRole === '财务'" class="role-section">
              <h3><i class="el-icon-money"></i> 财务端功能指南</h3>
              <el-collapse>
                <el-collapse-item title="项目管理" name="1">
                  <div class="guide-item">
                    <p>管理项目信息：</p>
                    <ul>
                      <li>录入/修改项目信息</li>
                      <li>项目编码与名称管理</li>
                      <li>项目金额与负责人设置</li>
                    </ul>
                  </div>
                </el-collapse-item>
                <el-collapse-item title="劳务费账单处理" name="2">
                  <div class="guide-item">
                    <p>账单管理功能：</p>
                    <ul>
                      <li>账单查询与撤销</li>
                      <li>账单受理与打款</li>
                      <li>状态更新与跟踪</li>
                    </ul>
                  </div>
                </el-collapse-item>
              </el-collapse>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      userRole: "", // teacher, manager, finance
      pendingTasks: 0,
      completedTasks: 0
    };
  },
  mounted() {
    debugger
    // 获取用户角色
    this.getUserRole();
    // 获取统计数据
    this.getStatistics();
  },
  methods: {
    getUserRole() {
      debugger
      // 从store中获取用户信息
      const roles = this.$store.getters && this.$store.getters.roles;
      debugger
      if (roles && roles.length > 0) {
        // 根据角色数组判断用户类型
        if (roles.includes('教师')) {
          this.userRole = '教师';
        } else if (roles.includes('负责人')) {
          this.userRole = '负责人';
        } else if (roles.includes('财务')) {
          this.userRole = '财务';
        } else {
          this.userRole = '';
        }
      } else {
        this.userRole = '';
      }
    },
    getStatistics() {
      // TODO: 获取待处理和已完成的任务数量
      this.pendingTasks = 5;
      this.completedTasks = 10;
    },
    goToNewLabor() {
      this.$router.push('/labor/submit');
    },
    goToAudit() {
      this.$router.push('/labor/audit');
    },
    goToProcess() {
      this.$router.push('/labor/process');
    }
  }
};
</script>

<style scoped lang="scss">
.home {
  .mt-20 {
    margin-top: 20px;
  }

  .role-guide {
    .guide-content {
      padding: 10px;
    }

    .role-section {
      margin-bottom: 20px;

      h3 {
        color: #303133;
        margin-bottom: 15px;
        
        i {
          margin-right: 8px;
        }
      }
    }

    .guide-item {
      padding: 10px;
      
      ul {
        padding-left: 20px;
        li {
          line-height: 24px;
          color: #606266;
        }
      }
    }
  }

  .system-stats {
    .stat-item {
      display: flex;
      align-items: center;
      padding: 20px;
      
      i {
        font-size: 40px;
        margin-right: 15px;
        color: #409EFF;
      }

      .stat-info {
        .stat-number {
          font-size: 24px;
          font-weight: bold;
          color: #303133;
        }

        .stat-label {
          font-size: 14px;
          color: #909399;
        }
      }
    }
  }

  .quick-actions {
    .el-button {
      width: 100%;
      margin-bottom: 10px;
    }
  }
}
</style>

