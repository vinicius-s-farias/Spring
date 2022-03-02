<template>
  <div id="app">
    <nav
      class="relative flex flex-wrap items-center justify-between px-2 py-4 bg-gray-800 mb-3"
    >
      <button @click="tog()" class="text-white text-2xl p-2 font-bold">
        &#9776;
      </button>
      <div
        class="container px-4 mx-auto flex flex-wrap items-center justify-between"
      >
        <div
          class="w-full relative lg:w-auto px-4 lg:static lg:block lg:justify-start"
        >
          <div class="flex justify-between">
            <img
              width="30"
              src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9Q_TOF8rxhZ5B6ELRNM-W2pOGHXAVdD3RDg&usqp=CAU"
              alt=""
            />
            <a
              class="text-base font-bold leading-relaxed inline-block mr-4 py-2 whitespace-nowrap uppercase text-white no-underline ml-2"
            >
              Solin-Vest
            </a>
          </div>
          <button
            class="cursor-pointer text-xl leading-none px-3 py-1 border border-solid border-transparent rounded bg-transparent block lg:hidden outline-none focus:outline-none"
            type="button"
          >
            <span class="block relative w-6 h-px rounded-sm bg-white"></span>
            <span
              class="block relative w-6 h-px rounded-sm bg-white mt-1"
            ></span>
            <span
              class="block relative w-6 h-px rounded-sm bg-white mt-1"
            ></span>
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
            <li type="button" v-on:click="toggleModal1()">
              <a
                class="px-3 py-2 flex items-center uppercase font-bold leading-snug text-white hover:opacity-75"
              >
                Profile
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

    <nav
      :class="open ? 'navbar-open' : 'navbar-close'"
      class="navbar w-64 absolute overflow-x-scroll bg-gray-800 top-20 h-screen"
    >
      <div class="flex pr-2 justify-center">
        <button @click="tog()" class="p-2"></button>
      </div>
      <div class="flex">
        <img
          width="30"
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9Q_TOF8rxhZ5B6ELRNM-W2pOGHXAVdD3RDg&usqp=CAU"
          alt=""
        />
        <a
          class="text-base font-bold leading-relaxed inline-block py-2 whitespace-nowrap uppercase text-white no-underline ml-0 px-8"
        >
          Solin-Vest
        </a>
      </div>
      <ul class="flex flex-col py-4">
        <li>
          <a
            href="#"
            class="flex flex-row items-center h-12 transform hover:translate-x-2 transition-transform ease-in duration-200 text-gray-500 hover:text-gray-800"
          >
            <span
              class="inline-flex items-center justify-center h-12 w-12 text-lg text-gray-400"
              ><i class="bx bx-home"></i
            ></span>

            <span class="text-sm font-medium text-white"></span>
            <router-link
              to="/"
              class="px-3 py-2 flex items-center uppercase font-bold leading-snug text-white hover:opacity-75"
              >Dashboard</router-link
            >
          </a>
        </li>
        <li>
          <a
            class="flex flex-row items-center h-12 transform hover:translate-x-2 transition-transform ease-in duration-200 text-gray-500 hover:text-gray-800"
          >
            <span
              class="inline-flex items-center justify-center h-12 w-12 text-lg text-gray-400"
              ><i class="bx bx-home"></i
            ></span>
            <router-link
              to="/About"
              class="px-3 py-2 flex items-center uppercase font-bold leading-snug text-white hover:opacity-75"
              v-if="authenticated"
            >
              About
            </router-link>
          </a>
        </li>
        <li>
          <button
            type="button"
            v-on:click="toggleModal()"
            @:click="Carteira1()"
          >
            <a
              class="flex flex-row items-center h-12 transform hover:translate-x-2 transition-transform ease-in duration-200 text-gray-500 hover:text-gray-800"
            >
              <span
                class="inline-flex items-center justify-center h-12 w-12 text-lg text-gray-400"
                ><i class="bx bx-user"></i
              ></span>
              <span
                class="px-3 py-2 flex items-center uppercase font-bold leading-snug text-white hover:opacity-75"
                >Carteira</span
              >
            </a>
          </button>
        </li>
        <li>
          <a
            href="#"
            class="flex flex-row items-center h-12 transform hover:translate-x-2 transition-transform ease-in duration-200 text-gray-500 hover:text-gray-800"
          >
            <span
              class="inline-flex items-center justify-center h-12 w-12 text-lg text-gray-400"
              ><i class="bx bx-bell"></i
            ></span>
            <span
              class="px-3 py-2 flex items-center uppercase font-bold leading-snug text-white hover:opacity-75"
              >Notifications</span
            >
          </a>
        </li>
        <li>
          <a
            v-if="authenticated"
            v-on:click="logout()"
            class="flex flex-row items-end h-12 transform hover:translate-x-2 transition-transform ease-in duration-200 text-gray-500 hover:text-gray-800"
          >
            <span
              class="inline-flex items-end justify-end h-12 w-12 text-lg text-gray-400"
              ><i class="bx bx-log-out"></i
            ></span>
            <span
              class="px-3 py-2 flex items-center uppercase font-bold leading-snug text-white hover:opacity-75 mt-48"
              >Logout</span
            >
          </a>
        </li>
      </ul>
    </nav>
    <div class="w-1/12">
      <div
        v-if="showModal"
        class="overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none justify-center items-center flex"
      >
        <div class="relative w-auto my-6 mx-auto max-w-6xl">
          <!--content-->
          <div
            class="border-0 rounded-lg shadow-lg relative flex flex-col w-full bg-white outline-none focus:outline-none"
          >
            <!--header-->
            <div
              class="flex items-start justify-center p-1 border-b border-solid border-blueGray-200 rounded-t"
            >
              <h5 class="text-3xl font-semibold">Carteira</h5>
            </div>
            <!--body-->
            <table class="divide-gray-200 w-full">
              <thead class="bg-gray-500">
                <tr>
                  <th
                    scope="col"
                    class="px-20 py-3 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
                  >
                    Ação
                  </th>
                  <th
                    scope="col"
                    class="px-20 py-3 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
                  >
                    Simbolo
                  </th>
                  <th
                    scope="col"
                    class="px-20 py-3 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
                  >
                    Volume
                  </th>
                </tr>
              </thead>
              <tbody class="bg-gray-100 divide-y divide-gray-200">
                <tr v-for="wallets in wallet" :key="wallets">
                  <td class="px-6 py-4 whitespace-nowrap">
                    <div class="flex items-center">
                      <div class="ml-4">
                        <div class="text-sm font-medium text-gray-900">
                          {{ wallets.stock_name }}
                        </div>
                      </div>
                    </div>
                  </td>
                  <td class="px-20 py-4 whitespace-nowrap">
                    <div class="text-sm text-gray-900">
                      {{ wallets.stock_symbol }}
                    </div>
                  </td>
                  <td class="px-20 py-4 whitespace-nowrap">
                    {{ wallets.volume }}
                  </td>
                </tr>
              </tbody>
            </table>

            <!--footer-->
            <div
              class="flex items-center justify-between p-3 border-t border-solid border-blueGray-200 rounded-b"
            >
              <h1 class="text-xl font-semibold">Patrimonio :</h1>
              <h1>{{ dolar }}</h1>
              <button
                class="py-3 px-8 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-red-300 hover:bg-gray-200 focus:outline-none"
                type="button"
                v-on:click="toggleModal()"
              >
                Close
              </button>
            </div>
          </div>
        </div>
      </div>
      <div
        v-if="showModal"
        class="opacity-25 fixed inset-0 z-40 bg-black"
      ></div>
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
    <div id="content">
      <router-view />
    </div>
  </div>
</template>

<script>
import "./assets/tailwind.css";
import axios from "axios";
export default {
  name: "app",
  data: function () {
    return {
      authenticated: false,
      open: false,
      showModal: false,

      wallet: [],
      id_user: 0,
      users: [],
      dollar: "",
    };
  },

  created() {
    this.Users();
    this.User1();
  },
  async created1() {
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
    tog() {
      this.open = !this.open;
    },
    toggleModal() {
      this.showModal = !this.showModal;
      this.Carteira1();
    },

    async Carteira1() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        console.log(`Authorization: Bearer ${accessToken}`);
        try {
          let response = await axios.get(
            `http://localhost:8081/wallet/${this.id_user}`,
            {
              headers: { Authorization: "Bearer " + accessToken },
            }
          );
          this.wallet = response.data;
          this.dolar = this.wallet[0].id_user.dollar_balance.toLocaleString(
            "pt-br",
            { style: "currency", currency: "BRL" }
          );
        } catch (error) {
          this.wallet = `${error}`;
        }
      }
    },

    async Users() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        console.log(`Authorization: Bearer ${accessToken}`);
        try {
          let response = await axios.get(
            `http://localhost:8081/teste/${this.id_user}`,
            {
              headers: { Authorization: "Bearer " + accessToken },
            }
          );
          this.users = response.data;
        } catch (error) {
          this.users = `${error}`;
        }
      }
    },
    async User1() {
      this.claims = await Object.entries(await this.$auth.getUser()).map(
        (entry) => ({ claim: entry[0], value: entry[1] })
      );
      let accessToken = this.$auth.getAccessToken();
      try {
        let response = await axios.get(
          `http://localhost:8081/users/${this.claims[1].value}`,

          {
            headers: { Authorization: "Bearer " + accessToken },
          }
        );
        console.log(response.data);
        this.id_user = response.data;
        console.log("olha pra baixo");
      } catch (error) {
        this.id_user = `${error}`;
      }
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
.navbar {
  transition: all 330ms ease-out;
}

.navbar-open {
  transform: translateX(0%);
}
.navbar-close {
  transform: translateX(-100%);
}
</style>
