<template>
  <div class="card">
    <div class="card-header">
      <div class="card-title">
        <h3 class="fw-bold">영상 업로드</h3>
      </div>
    </div>

    <div class="card-body">
      <!-- 파일 업로드 영역 -->
      <div class="row mb-8">
        <div class="col-12">
          <div class="dropzone dropzone-queue mb-2" id="video-dropzone">
            <div class="dropzone-panel mb-4">
              <input type="file" accept="video/*" @change="handleFileUpload" ref="fileInput" style="display: none;"/>
            </div>
          </div>

          <button @click="$refs.fileInput.click()" class="btn btn-primary btn-lg w-100" :disabled="isUploading">
            <i class="ki-duotone ki-folder-up fs-2">
              <span class="path1"></span>
              <span class="path2"></span>
            </i>
            {{ isUploading ? '처리 중...' : '영상 파일 선택' }}
          </button>
        </div>
      </div>

      <!-- 진행률 바 -->
      <div v-if="isUploading" class="row mb-8">
        <div class="col-12">
          <div class="d-flex align-items-center">
            <span class="fs-6 fw-semibold text-gray-700 me-3">업로드 진행률</span>
            <div class="progress flex-grow-1 me-3" style="height: 8px;">
              <div
                  class="progress-bar bg-primary"
                  :style="{ width: uploadProgress + '%' }"
              ></div>
            </div>
            <span class="fs-6 fw-bold text-primary">{{ uploadProgress }}%</span>
          </div>
        </div>
      </div>

      <!-- 영상 재생 영역 -->
      <div v-if="videoSrc" class="row">
        <div class="col-12">
          <div class="card bg-light">
            <div class="card-header">
              <h4 class="card-title">영상 미리보기</h4>
            </div>
            <div class="card-body text-center">
              <video
                  ref="videoPlayer"
                  :src="videoSrc"
                  controls
                  class="w-100"
                  style="max-height: 500px; border-radius: 10px;"
                  @loadeddata="onVideoLoaded"
              >
                브라우저가 비디오를 지원하지 않습니다.
              </video>

              <div class="mt-4">
                <div class="d-flex justify-content-center gap-3">
                  <button @click="playVideo" class="btn btn-success">재생</button>
                  <button @click="pauseVideo" class="btn btn-warning">정지 </button>
                  <button @click="resetVideo" class="btn btn-secondary">
                    <i class="ki-duotone ki-arrows-circle fs-2">
                      <span class="path1"></span>
                      <span class="path2"></span>
                    </i>
                    처음부터
                  </button>
                </div>
              </div>

              <div v-if="videoInfo" class="mt-4 text-start">
                <div class="bg-light-primary p-4 rounded">
                  <h5 class="text-primary mb-3">영상 정보</h5>
                  <div class="row">
                    <div class="col-sm-6">
                      <p class="mb-2"><strong>파일명:</strong> {{ videoInfo.name }}</p>
                      <p class="mb-2"><strong>크기:</strong> {{ formatFileSize(videoInfo.size) }}</p>
                    </div>
                    <div class="col-sm-6">
                      <p class="mb-2"><strong>타입:</strong> {{ videoInfo.type }}</p>
                      <p class="mb-2"><strong>업로드 시간:</strong> {{ videoInfo.uploadTime }}</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- 업로드된 영상이 없을 때 -->
      <div v-if="!videoSrc && !isUploading" class="row">
        <div class="col-12">
          <div class="text-center py-10">
            <h4 class="text-gray-600 mb-2">영상을 업로드하면 여기에 표시됩니다</h4>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'VideoUpload',
  data() {
    return {
      selectedFileName: '',
      videoSrc: null,
      isUploading: false,
      uploadProgress: 0,
      videoInfo: null
    }
  },
  methods: {
    handleFileUpload(event) {
      const file = event.target.files[0];
      if (!file) return;

      // 파일이 비디오인지 확인
      if (!file.type.startsWith('video/')) {
        this.showAlert('비디오 파일만 업로드할 수 있습니다.', 'error');
        return;
      }

      this.selectedFileName = file.name;
      this.videoInfo = {
        name: file.name,
        size: file.size,
        type: file.type,
        uploadTime: new Date().toLocaleString('ko-KR')
      };

      // 가짜 업로드 진행률 시뮬레이션
      this.simulateUpload(file);
    },

    simulateUpload(file) {
      this.isUploading = true;
      this.uploadProgress = 0;

      const interval = setInterval(() => {
        this.uploadProgress += 10;

        if (this.uploadProgress >= 100) {
          clearInterval(interval);
          this.isUploading = false;
          this.loadVideo(file);
          this.showAlert('영상이 성공적으로 업로드되었습니다!', 'success');
        }
      }, 200);
    },

    loadVideo(file) {
      // 파일을 URL로 변환하여 비디오 소스 설정
      this.videoSrc = URL.createObjectURL(file);
    },

    onVideoLoaded() {
      console.log('비디오가 로드되었습니다.');
    },

    playVideo() {
      if (this.$refs.videoPlayer) {
        this.$refs.videoPlayer.play();
      }
    },

    pauseVideo() {
      if (this.$refs.videoPlayer) {
        this.$refs.videoPlayer.pause();
      }
    },

    resetVideo() {
      if (this.$refs.videoPlayer) {
        this.$refs.videoPlayer.currentTime = 0;
        this.$refs.videoPlayer.play();
      }
    },

    formatFileSize(bytes) {
      if (bytes === 0) return '0 Bytes';
      const k = 1024;
      const sizes = ['Bytes', 'KB', 'MB', 'GB'];
      const i = Math.floor(Math.log(bytes) / Math.log(k));
      return parseFloat((bytes / Math.pow(k, i)).toFixed(2)) + ' ' + sizes[i];
    },

    showAlert(message, type) {
      // 메트로닉 알림 사용 (SweetAlert2가 포함되어 있다면)
      if (typeof Swal !== 'undefined') {
        Swal.fire({
          text: message,
          icon: type === 'success' ? 'success' : 'error',
          buttonsStyling: false,
          confirmButtonText: "확인",
          customClass: {
            confirmButton: "btn btn-primary"
          }
        });
      } else {
        alert(message);
      }
    }
  },

  beforeUnmount() {
    // 메모리 누수 방지를 위해 object URL 해제
    if (this.videoSrc) {
      URL.revokeObjectURL(this.videoSrc);
    }
  }
}
</script>