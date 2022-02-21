<template>
  <!-- COMEÇO Do STOCK -->

  <div class="py-40 flex w-full md:w-auto">
    <div class="bg-gray-300 rounded-lg shadow-2x1 w-full -mt-40">
      <!-- header -->

      <header
        class="flex justify-between bg-gray-800 rounded-t-lg py-1 px-8 text-xl font-normal text-white"
      >
        ESTOQUE
        <button
          type="submit"
          class="py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-black hover:bg-gray-500 focus:outline-none"
          @click="setup"
        >
          ATUALIZAR
        </button>
      </header>

      <table class="min-w-full divide-y divide-gray-200">
        <thead class="bg-gray-500">
          <tr>
            <th
              scope="col"
              class="px-20 py-2 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              Ação
            </th>
            <th
              scope="col"
              class="px-20 py-2 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              Simbolo
            </th>
            <th
              scope="col"
              class="px-20 py-2 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              Ask-Min
            </th>
            <th
              scope="col"
              class="px-20 py-2 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              Ask-Max
            </th>
            <th
              scope="col"
              class="px-20 py-2 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              BID-MIN
            </th>
            <th
              scope="col"
              class="px-20 py-2 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              BID-MAX
            </th>
          </tr>
        </thead>
        <tbody class="bg-gray-100 divide-y divide-gray-200">
          <tr v-for="stock in stocks" :key="stock">
            <td class="px-6 py-0 whitespace-nowrap">
              <div class="flex items-center">
                <div class="flex-shrink-0 h-10 w-10"></div>
                <div class="ml-4">
                  <div class="text-sm font-medium text-gray-900">
                    {{ stock.stock_name }}
                  </div>
                </div>
              </div>
            </td>
            <td class="px-20 py-0 whitespace-nowrap">
              <div class="text-sm text-gray-900">{{ stock.stock_symbol }}</div>
            </td>
            <td class="px-20 py-0 whitespace-nowrap">
              {{ stock.ask_min }}
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ stock.ask_max }}
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ stock.bid_min }}
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ stock.bid_max }}
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>

  <!-- COMEÇO DA ORDEM -->

  <div class="flex justify-between">
    <div class="bg-gray-100 rounded-lg shadow-2x1 w-7/12 -mt-36">
      <header
        class="flex justify-between bg-gray-800 rounded-t-lg py-2 px-8 text-xl font-extrabold text-white"
      >
        ORDEM
        <button
          type="submit"
          class="py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-black hover:bg-gray-500 focus:outline-none"
          @click="setup2"
        >
          ATUALIZAR
        </button>
      </header>
      <table class="divide-gray-200 w-full">
        <thead class="bg-gray-500">
          <tr>
            <th
              scope="col"
              class="px-16 py-3 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              Ação
            </th>
            <th
              scope="col"
              class="px-16 py-3 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              Simbolo
            </th>
            <th
              scope="col"
              class="px-14 py-3 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              Tipo
            </th>
            <th
              scope="col"
              class="px-16 py-3 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              Preço
            </th>
            <th
              scope="col"
              class="px-16 py-3 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              Volume
            </th>
          </tr>
        </thead>
        <tbody class="bg-gray-200 divide-y divide-gray-200">
          <tr v-for="orders in order" :key="orders">
            <td class="py-4 whitespace-nowrap">
              <div class="flex items-center">
                <div class="flex-shrink-0 h-10 w-10"></div>
                <div class="ml-4">
                  <div class="text-sm font-medium text-gray-900">
                    {{ orders.stock_name }}
                  </div>
                </div>
              </div>
            </td>
            <td class="px-16 py-4 whitespace-nowrap">
              <div class="text-sm text-gray-900">{{ orders.stock_symbol }}</div>
            </td>
            <td class="px-16 py-4 whitespace-nowrap" v-if="orders.type == 1">
              Venda
            </td>
            <td class="px-16 py-4 whitespace-nowrap" v-else>Compra</td>
            <td class="px-16 p y-4 whitespace-nowrap">{{ orders.price }}</td>
            <td class="px-16 py-4 whitespace-nowrap">
              {{ orders.remaining_value }}
            </td>
          </tr>
        </tbody>

        <button
          class="py-3 px-8 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-black hover:bg-gray-500 focus:outline-none"
          type="button"
          v-on:click="toggleModal()"
        >
          CRIAR ORDEM
        </button>
      </table>
      <div class="p-0"></div>
    </div>

    <!-- COMEÇO DA CARTEIRA -->
    <div class="bg-gray-300 rounded-lg shadow-2x1 -mt-36 w-4/12">
      <!-- header -->
      <header
        class="flex justify-between bg-gray-800 rounded-t-lg py-2 px-8 text-xl font-extrabold text-white"
      >
        CARTEIRA
        <button
          @click="Carteira()"
          type="submit"
          class="py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-black hover:bg-gray-500 focus:outline-none"
        >
          ATUALIZAR
        </button>
      </header>
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
                <div class="flex-shrink-0 h-10 w-10"></div>
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
            <td class="px-20 py-4 whitespace-nowrap">{{ wallets.volume }}</td>
          </tr>
        </tbody>
      </table>

      <div class="p-32"></div>
    </div>
  </div>
  <!-- COMEÇO MODAL -->
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
            <h5 class="text-3xl font-semibold">CREATE ORDEM</h5>
          </div>
          <!--body-->
          <form class="w-full max-w-lg p-3">
            <div class="w-full md:min-w-full mb-6 md:mb-0 pb-3">
              <div class="col-span-6">
                <label
                  class="justify-center block text-sm font-medium text-gray-700"
                  >Ação
                </label>
                <select
                  @click="selecStock"
                  v-model="name"
                  class="mt-1 mb- block w-full py-2 px-3 border bg-gray-200 border-gray-200 text-gray-700 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                >
                  <option v-for="stocks in seila" :key="stocks">
                    {{ stocks.stock_name }}
                  </option>
                </select>
              </div>
            </div>

            <div class="flex justify-evenly -mx-3 mb-2">
              <div class="w-1/2 md:w-1/3 px-3 mb-6 md:mb-0">
                <label
                  class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                  for="grid-state"
                >
                  Tipo
                </label>
                <div class="relative">
                  <select
                    v-model="type"
                    class="block appearance-none bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  >
                    <option value="1">Venda</option>
                    <option value="0">Compra</option>
                  </select>
                  <div
                    class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700"
                  ></div>
                </div>
              </div>

              <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                <label
                  class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                  for="grid-city"
                >
                  Quantidade
                </label>
                <input
                  v-model="volume"
                  class="appearance-none block w-10/12 bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  type="text"
                />
              </div>
              <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                <label
                  class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                  for="grid-zip"
                >
                  Preço
                </label>
                <input
                  v-model="price"
                  class="appearance-none block w-10/12 bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  type="text"
                />
              </div>
            </div>
          </form>
          <!--footer-->
          <div
            class="flex items-center justify-between p-3 border-t border-solid border-blueGray-200 rounded-b"
          >
            <button
              class="py-3 px-8 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-green-300 hover:bg-gray-200 focus:outline-none"
              @click="CreteOrdem"
              v-on:click="toggleModal()"
            >
              Salvar Ordem
            </button>
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
    <div v-if="showModal" class="opacity-25 fixed inset-0 z-40 bg-black"></div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "home",
  nome: "large-modal",
  data: function () {
    return {
      id_user: 0,
      users: [],
      seila: [],
      seila1: [],
      price: "",
      volume: "",
      type: "",
      name: "",
      username: "",
      showModal: false,
      claims: "",
      caffeineLevel: "",
      stocks: [],
      order: [],
      wallet: [],
    };
  },

  mounted() {
    this.setup();
    this.setup2();
    this.Carteira();
  },
  created() {
    this.User();
  },
  methods: {
    async setup() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        console.log(`Authorization: Bearer ${accessToken}`);
        try {
          let response = await axios.get("http://localhost:8082/stocks", {
            headers: { Authorization: "Bearer " + accessToken },
          });
          this.stocks = response.data;
        } catch (error) {
          this.stocks = `${error}`;
        }
        try {
          let response = await axios.get("http://localhost:8082/stocks/todos", {
            headers: { Authorization: "Bearer " + accessToken },
          });
          this.seila = response.data;
        } catch (error) {
          this.seila = `${error}`;
        }
      }
    },
    async setup2() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        console.log(`Authorization: Bearer ${accessToken}`);
        try {
          let response = await axios.get("http://localhost:8081/orders", {
            headers: { Authorization: "Bearer " + accessToken },
          });
          this.order = response.data;
        } catch (error) {
          this.order = `${error}`;
        }
      }
    },

    async Carteira() {
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
        } catch (error) {
          this.wallet = `${error}`;
        }
      }
    },

    async selecStock() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        try {
          let response = await axios.get(
            `http://localhost:8082/stocks/${this.name}`,

            {
              headers: { Authorization: "Bearer " + accessToken },
            }
          );
          this.seila1 = response.data;
          console.log("olha pra baixo");
          console.log(this.seila1);
        } catch (error) {
          this.seila1 = `${error}`;
        }
      }
    },
    async CreteOrdem() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        try {
          await axios.post(
            "http://localhost:8081/order",
            {
              id_user: this.id_user,
              id_stock: this.seila1[0].id,
              stock_name: this.name,
              stock_symbol: this.seila1[0].stock_symbol,
              price: this.price,
              status: 1,
              type: this.type,
              volume: this.volume,
              remaining_value: this.volume,
            },
            {
              headers: { Authorization: "Bearer " + accessToken },
            }
          );
          console.log("sucesso");
        } catch (error) {
          console.log(error);
        }
      }
    },

    async User() {
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

    toggleModal: function () {
      this.showModal = !this.showModal;
    },
  },
};
</script>
