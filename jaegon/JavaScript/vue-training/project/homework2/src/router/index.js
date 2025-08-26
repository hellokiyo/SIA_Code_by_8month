import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/search',
      name: 'search',
      component: () => import('../views/SearchView.vue'),
    },
    {
      path: '/post',
      name: 'post',
      component: () => import('../views/PostView.vue'),
    },
    {
      path: '/video',
      name: 'video',
      component: () => import('../views/VideoView.vue'),
    },
    {
      path: '/post-write',
      name: 'post-write',
      component: () => import('../views/PostWriteView.vue'),
    },
    {
      path: '/user',
      name: 'user',
      component: () => import('../views/UserView.vue'),
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/LoginView.vue'),
    },
      {
          path: '/about',
          name: 'about',
          component: () => import('../views/AboutView.vue'),
      }
  ],

})

export default router
