<template>
  <!-- <div id="home">
    <h1>Okta Single-Page App Demo</h1>
    <div v-if="!this.$root.authenticated">
      <p>
        How much caffeine has your developer had today?
        <router-link role="button" to="/login">Log in to find out!</router-link>
      </p>
    </div>

    <div v-if="this.$root.authenticated">
      <p>Welcome, {{ claims.name }}!</p>
      <p>
        {{ this.caffeineLevel }}
      </p>
    </div>
  </div> -->

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
          <tr v-for="person in people" :key="person.email">
            <td class="px-6 py-0 whitespace-nowrap">
              <div class="flex items-center">
                <div class="flex-shrink-0 h-10 w-10"></div>
                <div class="ml-4">
                  <div class="text-sm font-medium text-gray-900">
                    {{ person.name }}
                  </div>
                </div>
              </div>
            </td>
            <td class="px-20 py-0 whitespace-nowrap">
              <div class="text-sm text-gray-900">{{ person.title }}</div>
            </td>
            <td class="px-20 py-0 whitespace-nowrap">
              <span
                class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800"
              >
                Active
              </span>
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
          </tr>
        </tbody>
        <tbody class="bg-gray-100 divide-y divide-gray-200">
          <tr v-for="person in people" :key="person.email">
            <td class="px-6 py-0 whitespace-nowrap">
              <div class="flex items-center">
                <div class="flex-shrink-0 h-10 w-10"></div>
                <div class="ml-4">
                  <div class="text-sm font-medium text-gray-900">
                    {{ person.name }}
                  </div>
                </div>
              </div>
            </td>
            <td class="px-20 py-0 whitespace-nowrap">
              <div class="text-sm text-gray-900">{{ person.title }}</div>
            </td>
            <td class="px-20 py-0 whitespace-nowrap">
              <span
                class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800"
              >
                Active
              </span>
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
          </tr>
        </tbody>
        <tbody class="bg-gray-100 divide-y divide-gray-200">
          <tr v-for="person in people" :key="person.email">
            <td class="px-6 py- whitespace-nowrap">
              <div class="flex items-center">
                <div class="flex-shrink-0 h-10 w-10"></div>
                <div class="ml-4">
                  <div class="text-sm font-medium text-gray-900">
                    {{ person.name }}
                  </div>
                </div>
              </div>
            </td>
            <td class="px-20 py-0 whitespace-nowrap">
              <div class="text-sm text-gray-900">{{ person.title }}</div>
            </td>
            <td class="px-20 py-0 whitespace-nowrap">
              <span
                class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800"
              >
                Active
              </span>
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
          </tr>
        </tbody>
        <tbody class="bg-gray-100 divide-y divide-gray-200">
          <tr v-for="person in people" :key="person.email">
            <td class="px-6 py-0 whitespace-nowrap">
              <div class="flex items-center">
                <div class="flex-shrink-0 h-10 w-10"></div>
                <div class="ml-4">
                  <div class="text-sm font-medium text-gray-900">
                    {{ person.name }}
                  </div>
                </div>
              </div>
            </td>
            <td class="px-20 py-0 whitespace-nowrap">
              <div class="text-sm text-gray-900">{{ person.title }}</div>
            </td>
            <td class="px-20 py-0 whitespace-nowrap">
              <span
                class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800"
              >
                Active
              </span>
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
          </tr>
        </tbody>
        <tbody class="bg-gray-100 divide-y divide-gray-200">
          <tr v-for="person in people" :key="person.email">
            <td class="px-6 py-0 whitespace-nowrap">
              <div class="flex items-center">
                <div class="flex-shrink-0 h-10 w-10"></div>
                <div class="ml-4">
                  <div class="text-sm font-medium text-gray-900">
                    {{ person.name }}
                  </div>
                </div>
              </div>
            </td>
            <td class="px-20 py-0 whitespace-nowrap">
              <div class="text-sm text-gray-900">{{ person.title }}</div>
            </td>
            <td class="px-20 py-0 whitespace-nowrap">
              <span
                class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800"
              >
                Active
              </span>
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
            <td class="px-20 py-0 whitespace-nowrap text-sm text-gray-500">
              {{ person.role }}
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>

  <!-- COMEÇO DA ORDEM -->

  <div class="flex justify-between">
    <div class="bg-gray-300 rounded-lg shadow-2x1 w-7/12 -mt-36">
      <header
        class="flex justify-between bg-gray-800 rounded-t-lg py-2 px-8 text-xl font-extrabold text-white"
      >
        ORDEM
        <button
          type="submit"
          class="py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-black hover:bg-gray-500 focus:outline-none"
        >
          ATUALIZAR
        </button>
      </header>
      <table class="divide-gray-200">
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
              class="px-16 py-3 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              Simbolo
            </th>
            <th
              scope="col"
              class="px-16 py-3 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              Tipo
            </th>
            <th
              scope="col"
              class="px-20 py-3 text-left text-xs font-medium text-gray-50 uppercase tracking-wider"
            >
              Preço
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
          <tr v-for="person in people" :key="person.email">
            <td class="px-8 py-4 whitespace-nowrap">
              <div class="flex items-center">
                <div class="flex-shrink-0 h-10 w-10"></div>
                <div class="ml-4">
                  <div class="text-sm font-medium text-gray-900">
                    {{ person.name }}
                  </div>
                </div>
              </div>
            </td>
            <td class="px-16 py-4 whitespace-nowrap">
              <div class="text-sm text-gray-900">{{ person.title }}</div>
            </td>
            <td class="px-16 py-4 whitespace-nowrap">Active</td>
            <td class="px-16 py-4 whitespace-nowrap">Active</td>
            <td class="px-20 py-4 whitespace-nowrap">Active</td>
          </tr>
        </tbody>
        <tbody class="bg-gray-100 divide-y divide-gray-200">
          <tr v-for="person in people" :key="person.email">
            <td class="px-8 py-4 whitespace-nowrap">
              <div class="flex items-center">
                <div class="flex-shrink-0 h-10 w-10"></div>
                <div class="ml-4">
                  <div class="text-sm font-medium text-gray-900">
                    {{ person.name }}
                  </div>
                </div>
              </div>
            </td>
            <td class="px-16 py-4 whitespace-nowrap">
              <div class="text-sm text-gray-900">{{ person.title }}</div>
            </td>
            <td class="px-16 py-4 whitespace-nowrap">Active</td>
            <td class="px-16 py-4 whitespace-nowrap">Active</td>
            <td class="px-20 py-4 whitespace-nowrap">Active</td>
          </tr>
        </tbody>
        <tbody class="bg-gray-100 divide-y divide-gray-200">
          <tr v-for="person in people" :key="person.email">
            <td class="px-8 py-4 whitespace-nowrap">
              <div class="flex items-center">
                <div class="flex-shrink-0 h-10 w-10"></div>
                <div class="ml-4">
                  <div class="text-sm font-medium text-gray-900">
                    {{ person.name }}
                  </div>
                </div>
              </div>
            </td>
            <td class="px-16 py-4 whitespace-nowrap">
              <div class="text-sm text-gray-900">{{ person.title }}</div>
            </td>
            <td class="px-16 py-4 whitespace-nowrap">Active</td>
            <td class="px-16 py-4 whitespace-nowrap">Active</td>
            <td class="px-20 py-4 whitespace-nowrap">Active</td>
          </tr>
        </tbody>
        <tbody class="bg-gray-100 divide-y divide-gray-200">
          <tr v-for="person in people" :key="person.email">
            <td class="px-8 py-4 whitespace-nowrap">
              <div class="flex items-center">
                <div class="flex-shrink-0 h-10 w-10"></div>
                <div class="ml-4">
                  <div class="text-sm font-medium text-gray-900">
                    {{ person.name }}
                  </div>
                </div>
              </div>
            </td>
            <td class="px-16 py-4 whitespace-nowrap">
              <div class="text-sm text-gray-900">{{ person.title }}</div>
            </td>
            <td class="px-16 py-4 whitespace-nowrap">Active</td>
            <td class="px-16 py-4 whitespace-nowrap">Active</td>
            <td class="px-20 py-4 whitespace-nowrap">Active</td>
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
      <div class="p-8"></div>
    </div>

    <!-- COMEÇO DA CARTEIRA -->
    <div class="bg-gray-300 rounded-lg shadow-2x1 -mt-36 table-auto">
      <!-- header -->
      <header
        class="flex justify-between bg-gray-800 rounded-t-lg py-2 px-8 text-xl font-extrabold text-white"
      >
        CARTEIRA
        <button
          type="submit"
          class="py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-black hover:bg-gray-500 focus:outline-none"
        >
          ATUALIZAR
        </button>
      </header>
      <table class="divide-gray-200">
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
          <tr v-for="person in people" :key="person.email">
            <td class="px-6 py-4 whitespace-nowrap">
              <div class="flex items-center">
                <div class="flex-shrink-0 h-10 w-10"></div>
                <div class="ml-4">
                  <div class="text-sm font-medium text-gray-900">
                    {{ person.name }}
                  </div>
                </div>
              </div>
            </td>
            <td class="px-20 py-4 whitespace-nowrap">
              <div class="text-sm text-gray-900">{{ person.title }}</div>
            </td>
            <td class="px-20 py-4 whitespace-nowrap">
              <span
                class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full"
              >
                Active
              </span>
            </td>
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
          <form class="w-full max-w-lg">
            <div class="w-full md:min-w-full mb-6 md:mb-0">
              <div class="col-span-6">
                <label
                  for="country"
                  class="justify-center block text-sm font-medium text-gray-700"
                  >Ação
                </label>
                <select
                  id="country"
                  name="country"
                  autocomplete="country-name"
                  class="mt-1 mb- block w-full py-2 px-3 border bg-gray-200 border-gray-200 text-gray-700 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                >
                  <option>---- Selecione a ação ----</option>
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
                    class="block appearance-none bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                    id="grid-state"
                  >
                    <option>Venda</option>
                    <option>Compra</option>
                  </select>
                  <div
                    class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700"
                  >
                    <svg
                      class="fill-current h-4 w-4"
                      xmlns="http://www.w3.org/2000/svg"
                      viewBox="0 0 20 20"
                    >
                      <path
                        d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"
                      />
                    </svg>
                  </div>
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
                  class="appearance-none block w-10/12 bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  id="grid-city"
                  type="text"
                  placeholder="Albuquerque"
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
                  class="appearance-none block w-10/12 bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  id="grid-zip"
                  type="text"
                  placeholder="90210"
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
const people = [
  {
    name: "Jane Cooper",
    title: "Regional Paradigm Technician",
    department: "Optimization",
    role: "Admin",
    email: "jane.cooper@example.com",
  },
  // More people...
];
export default {
  name: "home",
  nome: "large-modal",
  data: function () {
    return {
      showModal: false,
      people,
      claims: "",
      caffeineLevel: "",
    };
  },
  created() {
    this.setup();
  },
  methods: {
    async setup() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        console.log(`Authorization: Bearer ${accessToken}`);
        try {
          let response = await axios.get(
            "http://localhost:8081/howcaffeinatedami",
            { headers: { Authorization: "Bearer " + accessToken } }
          );
          this.caffeineLevel = response.data;
        } catch (error) {
          this.caffeineLevel = `${error}`;
        }
      }
    },
    toggleModal: function () {
      this.showModal = !this.showModal;
    },
  },
};
</script>
