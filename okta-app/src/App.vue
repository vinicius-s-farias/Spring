<template>
  <nav
    class="relative flex flex-wrap items-center justify-between px-2 py-3 bg-gray-800 mb-3"
  >
    <div
      class="container px-4 mx-auto flex flex-wrap items-center justify-between"
    >
      <div
        class="w-full relative flex justify-between lg:w-auto px-4 lg:static lg:block lg:justify-start"
      >
        <a
          class="text-sm font-bold leading-relaxed inline-block mr-4 py-2 whitespace-nowrap uppercase text-white"
        >
          <router-link to="/"> Home </router-link>
        </a>
        <button
          class="cursor-pointer text-xl leading-none px-3 py-1 border border-solid border-transparent rounded bg-transparent block lg:hidden outline-none focus:outline-none"
          type="button"
        >
          <span class="block relative w-6 h-px rounded-sm bg-white"></span>
          <span class="block relative w-6 h-px rounded-sm bg-white mt-1"></span>
          <span class="block relative w-6 h-px rounded-sm bg-white mt-1"></span>
        </button>
      </div>
      <div class="lg:flex flex-grow items-center" id="example-navbar-warning">
        <ul class="flex flex-col lg:flex-row list-none ml-auto">
          <li class="nav-item">
            <a
              class="px-3 py-2 flex items-center uppercase font-bold leading-snug text-white hover:opacity-75"
            >
              <router-link to="/login" v-if="!authenticated">
                Login
              </router-link>
            </a>
          </li>
          <li class="nav-item">
            <a
              class="px-3 py-2 flex items-center uppercase font-bold leading-snug text-white hover:opacity-75"
            >
              <router-link to="/profile" v-if="authenticated">
                Profile
              </router-link>
            </a>
          </li>
          <li class="nav-item">
            <a
              class="px-3 py-2 flex items-center uppercase font-bold leading-snug text-white hover:opacity-75"
            >
              <router-link to="/About" v-if="authenticated">
                About
              </router-link>
            </a>
          </li>
          <t-button>
            <li class="nav-item">
              <a
                v-if="authenticated"
                v-on:click="logout()"
                class="px-3 py-2 flex items-center uppercase font-bold leading-snug text-white hover:opacity-75"
                href="#pablo"
              >
                Logout
              </a>
            </li>
          </t-button>
        </ul>
      </div>
    </div>
  </nav>
  <div id="content">
    <router-view />
  </div>

  <div>
    <footer
      class="bg-gray-800 shadow md:p-6 dark:bg-gray-800 fixed inset-x-0 bottom-0 md:text-center text-white"
    >
      © 2022 Solin-Vest.
      <!-- <span class="text-sm text-gray-500 dark:text-gray-400"
        >
      </span> -->
    </footer>
  </div>
</template>

<script>
import "./assets/tailwind.css";
export default {
  name: "app",
  data: function () {
    return { authenticated: false };
  },
  async created() {
    await this.isAuthenticated();
    this.$auth.authStateManager.subscribe(this.isAuthenticated);
  },
  watch: {
    // Everytime the route changes, check for auth status
    $route: "isAuthenticated",
  },
  methods: {
    async isAuthenticated() {
      this.authenticated = await this.$auth.isAuthenticated();
    },
    async logout() {
      await this.$auth.signOut();
    },
    toggle() {
      this.open = !this.open;
    },
  },
};
</script>

<style>
nav div a {
  margin-right: 30px;
}
#app {
  width: 1900px;
  margin: 0 auto;
}
a {
  text-decoration: underline;
  cursor: pointer;
}
</style>
