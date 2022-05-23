document.addEventListener("DOMContentLoaded", function() {

// uchwyty elementy podsumowania
  const summary = document.querySelectorAll("[data-step] .summary--text");
  const items = summary[0];
  const institutionSummary = summary[1];

  const adresSummary = document.querySelectorAll(".summary .form-section--columns ul")[0];
  const streetSummary = adresSummary.querySelectorAll("li")[0];
  const citySummary = adresSummary.querySelectorAll("li")[1];
  const zipCodeSummary = adresSummary.querySelectorAll("li")[2];
  const phoneNumberSummary = adresSummary.querySelectorAll("li")[3];

  const receivingSummary = document.querySelectorAll(".summary .form-section--columns ul")[1];
  const dateSummary = receivingSummary.querySelectorAll("li")[0];
  const timeSummary = receivingSummary.querySelectorAll("li")[1];
  const commentSummary = receivingSummary.querySelectorAll("li")[2];

  let institutionChecked;
  let categoryChecked;

  // console.log("adresSummary", adresSummary);
  // console.log("receivingSummary", receivingSummary);
  // console.log("text1" , items.innerHTML);
  // console.log("text2" , donationTarget.innerHTML);
  // console.log("streetSummary", streetSummary);
  // console.log("citySummary", citySummary);
  // console.log("zipCode", zipCodeSummary);
  // console.log("phoneNumber", phoneNumberSummary);
  // console.log("dateSummary", dateSummary);
  // console.log("timeSummary", timeSummary);
  // console.log("commentSummary", commentSummary);

  /**
   * Form Select
   */
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      // Input for value
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      // Dropdown container
      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      // List container
      this.ul = document.createElement("ul");

      // All list options
      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          // First clickable option
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        // Save new value only when clicked on li
        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }
  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  /**
   * Hide elements when clicked on document
   */
  document.addEventListener("click", function(e) {
    const target = e.target;
    const tagName = target.tagName;

    if (target.classList.contains("dropdown")) return false;

    if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
      return false;
    }

    if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
      return false;
    }

    document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
      el.classList.remove("selecting");
    });
  });

  /**
   * Switching between form steps
   */
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();
    }

    /**
     * Init all methods
     */
    init() {
      this.events();
      this.updateForm();
    }

    /**
     * All events that are happening in form
     */
    events() {
      // Next step
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep++;
          this.updateForm();
        });
      });

      // Previous step
      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep--;
          this.updateForm();
        });
      });

      // Form submit
      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    /**
     * Update form front-end
     * Show next or previous section etc.
     */
    updateForm() {
      this.$step.innerText = this.currentStep;

      // TODO: Validation

      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;



      // TODO: get data from inputs and show them in summary

      function getSummary(sourceElement, resultElement){
        if(sourceElement!=null){
          const activeButtonInFunction = document.querySelector(".active button.next-step");
          // console.log("activeButtonInFunction", activeButtonInFunction);
          activeButtonInFunction.addEventListener("click", evt => {
            // console.log("sourceElement.value", sourceElement.value);
            resultElement.innerHTML=sourceElement.value;
          });
        }
      }

      function getElement(id){
        let result = document.querySelector(`.active #${id}`);
        return result;
      }

      const quantityEl = document.querySelector(".active #quantity");
      const streetEl = document.querySelector(".active #street");
      const cityEl = document.querySelector(".active #city");
      const zipCodeEl = getElement("zipCode");
      const phoneEl = getElement("phone");
      const dateEl = getElement("pickedUpDate");
      const timeEl = getElement("pickedUpTime");
      const commentEl = getElement("pickUpComment");



      // console.log("quantityElInner", quantityEl);
      // console.log("streetEl", streetEl);
      // console.log("cityEl", cityEl);
      // console.log("zipCodeEl", zipCodeEl);
      console.log("phoneEl", phoneEl);
      // console.log("dateEl", dateEl);
      // console.log("timeEl", timeEl);
      // console.log("commentEl", commentEl);
      // console.log("institutionEl", institutionEl);

      getSummary(quantityEl, items);
      getSummary(streetEl, streetSummary);
      getSummary(cityEl, citySummary);
      getSummary(zipCodeEl, zipCodeSummary);

      getSummary(phoneEl, phoneNumberSummary);

      getSummary(dateEl, dateSummary);
      getSummary(timeEl, timeSummary);
      getSummary(commentEl, commentSummary);

      // checkedForms start

      function getCheckboxSummary(checkboxEl){
        let arr = [];
        const activeButtonInFunction = document.querySelector(".active button.next-step");
        console.log("activeButtonInFunction", activeButtonInFunction);
        activeButtonInFunction.addEventListener("click", evt => {
          checkboxEl.forEach(el => {
            if(el.checked){
              console.log("el", el)
              let tmp = el.parentElement.querySelector(".description .title").innerHTML;
              console.log("elParent: ", el.parentElement.querySelector(".description .title").innerHTML);
              arr.push(tmp);
            }
          })
        });
        return arr;
      }

      let categoryEl;
      if(this.currentStep===1){
        categoryChecked=[];
        categoryEl = document.querySelectorAll(".active .form-group input");
        let arr = [];
        const activeButtonInFunction = document.querySelector(".active button.next-step");
        console.log("activeButtonInFunction", activeButtonInFunction);
        activeButtonInFunction.addEventListener("click", evt => {
          categoryEl.forEach(el => {
            console.log("el", el);
            if(el.type!=="hidden" && el.checked===true){
              console.log("Element checked: ", el.checked);
              arr.push(el.parentElement.querySelector(".description").innerHTML);
              console.log("description: ", el.parentElement.querySelector(".description").innerHTML);
            }
          })
          console.log("arr", arr);
          categoryChecked = arr;
        });
      }
      console.log("categoryChecked: ", categoryChecked);


      let institutionEl;
      if(this.currentStep===3){
        institutionEl = document.querySelectorAll(".active .form-group input");
        institutionChecked=getCheckboxSummary(institutionEl);
      }

      // wprowadzenie zmian w kroku podsumowującym
      console.log("institutionChecked: ", institutionChecked );
      if (this.currentStep===5){
        institutionSummary.innerHTML = institutionChecked.toString();
        items.innerHTML = items.innerHTML + " worki z kategorii: " + categoryChecked.toString();
      }

      // checkedForms end

    }
  }
  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }

  // nowy listener na click na input type chceckobox color =>  yelow;

  // uchwyty do elelemntów formularza, pobrać value / check /
  // przed zapisem lub jeden krok mniej
});


