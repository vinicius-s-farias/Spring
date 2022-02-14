import { createRouter, createWebHistory } from "vue-router";
import { LoginCallback, navigationGuard } from "@okta/okta-vue";
import HomeComponent from "@/components/Home";
import LoginComponent from "@/components/Login";
import ProfileComponent from "@/components/Profile";
import About from "@/views/About";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      component: HomeComponent,
      meta: {
        requiresAuth: true,
      },
    },
    {
      path: "/About",
      component: About,
    },
    {
      path: "/login",
      component: LoginComponent,
    },
    {
      path: "/login/callback",
      component: LoginCallback,
    },
    {
      path: "/profile",
      component: ProfileComponent,
      meta: {
        requiresAuth: true,
      },
    },
  ],
});

router.beforeEach(navigationGuard);

export default router;
