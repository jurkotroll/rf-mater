(ns rf-mater.views
  (:require [re-frame.core :as re-frame]
            [rf-mater.subs :as subs]
            ;; [cljsjs.material-ui]
            ;; [cljs-react-material-ui.core :refer [get-mui-theme color]]
            ;; [cljs-react-material-ui.reagent :as ui]
            ;; [cljs-react-material-ui.icons :as ic]
            ;; [garden.core :refer [css]]
            [reagent.core :as r]
          ;;["" :default ]
            ["@material-ui/core/AppBar" :default AppBar]
            ["@material-ui/core/Button" :default Button]
            ["@material-ui/core/Card" :default Card]
            ["@material-ui/core/CardActions" :default CardActions]
            ["@material-ui/core/CardContent" :default CardContent]
            ["@material-ui/core/CardMedia" :default CardMedia]
            ["@material-ui/core/CardHeader" :default CardHeader]
            ["@material-ui/core/Collapse" :default Collapse]
            ["@material-ui/core/Avatar" :default Avatar]


            ["@material-ui/core/IconButton" :default IconButton]
            ["@material-ui/core/Toolbar" :default Toolbar]
            ["@material-ui/core/Typography" :default Typography]
            ["@material-ui/core/styles" :refer [MuiThemeProvider createMuiTheme]]

            ["@material-ui/icons/Favorite" :default FavoriteIcon]
            ["@material-ui/icons/Share" :default ShareIcon]
            ["@material-ui/icons/ExpandMore" :default ExpandMoreIcon]
            ["@material-ui/icons/MoreVert" :default MoreVertIcon]
            ["@material-ui/icons/Menu" :default MenuIcon]
            ))


(def theme (createMuiTheme #js {}))

(def styles {:root {:flex-grow "1"}
             :flex {:flex "1"}
             :menu-button {:margin-left "-12px"
                           :margin-right "20px"}
             :cont-center {:display "flex"
					                 :justify-content "center"
					                 :width "100%"}
             :card {:width "80%"
                    :margin-top "20px"
                    }
             :media {:height "0px"
                     :padding-top "56.25%"}
             :actions {:display "flex"}
             :expand {:margin-left "auto"
                      ; :transform "rotate(0deg)"
                      ; :transition
                       }
             :avatar {:backgroundcolor "red"}

             })

(js/console.log (:menu-button styles))





(defn event-card []
  [:div {:style (:cont-center styles)}
   [:> Card {:style (:card styles)}
    [:> CardHeader {
                    ;:avatar
										;		[:> Avatar {:aria-label "Recipe"
                    ;            :style (:avatar styles)}
                    ;  "R"]
                    ; :action
                    ;   [:> IconButton
                    ;     [:> MoreVertIcon]]
                    :title "Shrimp and Chorizo Paella"
                    :subheader "September 14, 2016"}]
     ; [:> CardMedia {:style (:media styles)
     ;                :image ""
     ;                :title "Contemplative Reptile"}]
     [:> CardContent
       [:> Typography {:component "p"}
         "This impressive paella is a perfect party dish and a fun meal to cook together
 with your guests. Add 1 cup of frozen peas along with the mussels, if you like."]]
     [:> CardActions {:style (:actions styles)
                      :disable-action-spacing 0
                      }
        [:> IconButton {:aria-label "Add to favorites"}
          [:> FavoriteIcon]]
        [:> IconButton {:aria-label "Share"}
          [:> ShareIcon]]
        [:> IconButton {:aria-label "Show more"
                        :style (:expand styles)
                        ;:on-click
                        ;:aria-expanded
                        }
          [:> ExpandMoreIcon]]]
     [:> Collapse {:in 1}
       [:> CardContent
         [:> Typography {:paragraph 1 :variant "body2"}
           "Method:"]
         [:> Typography {:paragraph 1}
           "Heat 1/2 cup of the broth in a pot until simmering, add saffron and set aside
 for 10 minutes."]
         [:> Typography {:paragraph 1}
           "Heat oil in a (14- to 16-inch) paella pan or a large, deep skillet over medium-high
                heat. Add chicken, shrimp and chorizo, and cook, stirring occasionally until lightly
                browned, 6 to 8 minutes. Transfer shrimp to a large plate and set aside, leaving
                chicken and chorizo in the pan. Add pimentón, bay leaves, garlic, tomatoes, onion,
                salt and pepper, and cook, stirring often until thickened and fragrant, about 10
                minutes. Add saffron broth and remaining 4 1/2 cups chicken broth; bring to a boil."]
         [:> Typography {:paragraph 1}
           "Add rice and stir very gently to distribute. Top with artichokes and peppers, and
                cook without stirring, until most of the liquid is absorbed, 15 to 18 minutes.
                Reduce heat to medium-low, add reserved shrimp and mussels, tucking them down into
                the rice, and cook again without stirring, until mussels have opened and rice is
                just tender, 5 to 7 minutes more. (Discard any mussels that don’t open.)"]
         [:> Typography
           "Set aside off of the heat to let rest for 10 minutes, and then serve."]
        ]]]])

(defn app-bar []
        [:> AppBar {:position "static"}
	        [:> Toolbar
	          [:> IconButton {:style (:menu-button styles)
	                          :color "inherit"
	                          :aria-label "Menu"}
	            [:> MenuIcon]]
	          [:> Typography {:variant "title"
	                          :color "inherit"
	                          :style (:flex styles)}
	            "Razem Na Stok"]
	          [:> Button {:color "inherit"}
	            "Login"]]
	       ])

(defn main-panel []
  [:> MuiThemeProvider {:theme theme}
    [:div {:style (:root styles)}
      [app-bar]
    	[event-card]
]])






;; (defn destination-card []
;;   (let []
;;     (fn []
;;       [ui/card {:style {:margin "10px 0px"}}

;;          [:div.destination {:style {:padding "5px"
;;                         :display "flex"
;;                         :justify-content "space-between"
;;                        :align-items "center"}}

;;           [ui/card-title {:title "Jańskie Łaźnie"
;;                           :subtitle "miejsce docelowe"
;;                           :style {:padding "5px"}}]

;;           [ui/raised-button {:label "negocjacja"
;;                               :primary true
;;                               :disable false}]]

;;         [:div.day {:style {:padding "5px"
;;                        :display "flex"
;;                        :justify-content "space-between"
;;                        :align-items "center"}}

;;           [ui/card-title {:title "sobota, 14-04-18"
;;                           :subtitle "dzień wyjazdu"
;;                           :style {:padding "5px"
;;                                    :font-size "20px"}}]

;;           [ui/raised-button {:label "negocjacja"
;;                              :primary true
;;                              :disable false}]]
;;         [ui/divider]
;;         [ui/card-text
;;           [ui/table
;;             [ui/table-body {:display-row-checkbox false}
;;               [ui/table-row
;;                 [ui/table-row-column "odległosc"]
;;                  [ui/table-row-column "150km"]
;;               ]
;;               [ui/table-row
;;                 [ui/table-row-column "w drodze"]
;;                  [ui/table-row-column "2,5h"]
;;               ]
;;               [ui/table-row
;;                 [ui/table-row-column "wyjazd"]
;;                  [ui/table-row-column "7:00"]
;;               ]
;;               [ui/table-row
;;                 [ui/table-row-column "na stoku"]
;;                  [ui/table-row-column "8h"]
;;               ]
;;               [ui/table-row
;;                 [ui/table-row-column "powrot"]
;;                  [ui/table-row-column "18:00"]
;;               ]]]]
;;        ])))

;; (defn avatarN []
;;   [ui/avatar "2"])

;; (defn tabel-row-passenger [])


;; (defn passenger-entry []
;;   (let [pas-name (r/atom "")]
;;     (fn []
;;       [:div {:style {:padding "5px"
;;                      :display "flex"
;;                      :justify-content "space-between"
;;                       :align-items "center"}}
;;                   [ui/text-field {:hint-text "wpisz imię"
;;                                   :floating-label-text "pasażer 3"
;;                                   :type "text"
;;                                   :value @pas-name
;;                                   :on-change #(reset! pas-name (-> % .-target .-value))
;;                                   ; :on-save #(when (seq %)
;;                                   ;             (re-frame/dispatch [:add-passenger %]))
;;                                   :on-save (fn [args] (js/console.log args))
;;                                   }]
;;                   [ui/floating-action-button {:mini true
;;                                               :primary true
;;                                               :on-click #(when (seq @pas-name)
;;                                                              (re-frame/dispatch [:add-passenger @pas-name]))}
;;                     [ic/content-add]]])))

;; (defn person-view [name status]
;;   [ui/table-row
;; 		[ui/table-row-column name]
;; 		 [ui/table-row-column status]])

;; (defn cards-with-passangers []
;;  (let [driver @(re-frame/subscribe [:driver])
;;        passengers @(re-frame/subscribe [:passengers])]
;;           [ui/card-text
;; 	          [ui/table ;{:display-row-checkbox false}
;; 	             [ui/table-header {:display-select-all false
;; 	                              :adjust-for-checkbox false}
;; 	              [ui/table-row
;; 	                [ui/table-header-column "imię"]
;; 	                [ui/table-header-column "status"]]]
;; 	            [ui/table-body {:display-row-checkbox false}
;; 	              [ui/table-row
;; 	                [ui/table-row-column (get driver :name)]
;; 	                 [ui/table-row-column "kierowca"]]
;; 								(map-indexed
;;                    (fn [idx person] [person-view (:name person)
;;                                      (str "pasażer " (inc idx))])
;;                   passengers)]]
;; 	           [passenger-entry]]))

;; (defn car-card []
;;   (let []
;;     (fn []
;;       [ui/card {:style {:margin "10px 0px"}}
;;         [:div.destination {:style {:padding "5px"
;;                         :display "flex"
;;                         :justify-content "space-between"
;;                        :align-items "center"}}
;;            [ui/card-title {:title "VW T4"
;;                           :subtitle (str "czerwony" ", " "Blueberry Machine" ", " "miejsc razem " "5")
;;                           :style {:padding "5px"}}]
;;            ;(avatarN)
;;           [ui/badge {:badge-content "3"
;;                      :primary true
;;                       :style {:display "flex"
;;                      ;:flex-grow "2"
;;                      :padding "12px 12px 12px 12px"}}
;;             [ui/avatar {:color (color :deepOrange300)
;;                         :backgroundcolor (color :purple500)
;;                         ;:size "80"
;;                         :margin "0px"
;;                         :children "2"
;;                          }
;;               ]]
;;           ]
;;         [ui/divider]
;; 				[cards-with-passangers]
;;        ])))




;; (defn home-panel []
;;   (let [name (re-frame/subscribe [::subs/name])]

;;      ;[:div [:h1 (str "Hello from " @name ". This is the Home Page.")]
;;      [ui/mui-theme-provider {:mui-theme (get-mui-theme
;;                                          ;(aget js/MaterialUIStyles "DarkRawTheme")
;;                                          )}
;;          [:div
;;            [app-bar]
;;            ;[jumbotron]

;;           [destination-card]
;;            [car-card]
;;           [:a {:href "#/about"} "go to About Page"]


;;         ]
;;       ]
;;      ))


;; ;; about

;; (defn about-panel []
;;   [:div "This is the About Page."
;;    [:div [:a {:href "#/"} "go to Home Page"]]])


;; ;; main

;; (defn- panels [panel-name]
;;   (case panel-name
;;     :home-panel [home-panel]
;;     :about-panel [about-panel]
;;     [:div]))

;; (defn show-panel [panel-name]
;;   [panels panel-name])

;; (defn main-panel []
;;   (let [active-panel (re-frame/subscribe [::subs/active-panel])]
;;     [show-panel @active-panel]))
